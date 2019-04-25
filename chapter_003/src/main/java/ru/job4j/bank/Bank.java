package ru.job4j.bank;

import java.util.*;

/**
 * class Bank
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.04.2019
 */
public class Bank {
    private final Map<User, List<Account>> userAccounts = new HashMap<>();

    /**
     * The method adds a new user to the database.
     * @param user A user object.
     */
    public void addUser(User user) {
        this.userAccounts.put(user, new ArrayList<>());
    }

    /**
     * The method deletes an existing user from the database.
     * @param user A user object.
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    /**
     * The method adds a new banking account using Passport Data of User.
     * @param passport Passport data of user.
     * @param account A new account of user.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> listAccounts = this.userAccounts.putIfAbsent(
                this.getUserByPassport(passport), new ArrayList<>(Arrays.asList(account))
        );
        if (listAccounts != null) {
            listAccounts.add(account);
            userAccounts.put(getUserByPassport(passport), listAccounts);
        }

    }

    /**
     * The method deletes the user account from the database of the bank.
     * @param passport Passport data of user.
     * @param account A new account of user.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> listAccounts = this.userAccounts.get(this.getUserByPassport(passport));
        for (int index = 0; index < listAccounts.size(); index++) {
            if (listAccounts.get(index).getRequisites().equals(account.getRequisites())) {
                listAccounts.remove(listAccounts.get(index));
                break;
            }
        }
    }

    /**
     * The method returns all User's Accounts.
     * @param passport Passport data of user.
     * @return List of all banking accounts of the User.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userAccounts.get(this.getUserByPassport(passport));
    }

    /**
     * The method provides banking transfer opertion between accounts.
     * @param srcPassport Passport data of sender.
     * @param srcRequisite Sender's account requisite.
     * @param destPassport Passport data of recipient.
     * @param destRequisite Recipient's account requisite.
     * @param amount Amount of money for sending.
     * @return Bank transfer success.
     */
    public boolean transferMoney(
            String srcPassport, String srcRequisite, String destPassport,
            String destRequisite, double amount) {
        boolean result = false;
        Account accountSrc = getAccountByRequisite(getUserByPassport(srcPassport), srcRequisite);
        Account accountDest = getAccountByRequisite(getUserByPassport(destPassport), destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getValue() >= amount) {
            accountSrc.setValue(accountSrc.getValue() - amount);
            accountDest.setValue(accountDest.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     * The method finds a user by their passport data.
     * @param passport Passpert data of user.
     * @return Object of user.
     */
    public User getUserByPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> client : userAccounts.entrySet()) {
            if (client.getKey().getPassport().equals(passport)) {
                user = client.getKey();
                break;
            }
        }
        return user;
    }

    /**
     * The method searches a User's Account using Account's Requisite.
     * @param user Object of user.
     * @param requisite Requisite of banking Account.
     * @return An Object of User's banking Account.
     */
    private Account getAccountByRequisite(User user, String requisite) {
        Account result = null;
        for (Account account : this.userAccounts.get(user)) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" + "accouns=" + userAccounts + "}";
    }
}