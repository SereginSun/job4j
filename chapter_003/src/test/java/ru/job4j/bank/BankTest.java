package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * class BankTest
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.04.2019
 */
public class BankTest {
    Bank sberBank = new Bank();
    User firstUser = new User("Kirill", "20 05 558346");
    User secondUser = new User("Matvey", "37 05 033791");
    User thirdUser = new User("Olga", "45 07 691152");
    List<Account> accounts = new ArrayList<>();

    @Before
    public void init() {
        sberBank.addUser(firstUser);
        sberBank.addUser(secondUser);
        sberBank.addUser(thirdUser);
        accounts.add(new Account(850.50, "322153"));
        accounts.add(new Account(100.73, "345823"));
        accounts.add(new Account(475.87, "651219"));
        accounts.add(new Account(50.0, "101202"));
        sberBank.addAccountToUser(firstUser.getPassport(), accounts.get(0));
        sberBank.addAccountToUser(secondUser.getPassport(), accounts.get(1));
        sberBank.addAccountToUser(thirdUser.getPassport(), accounts.get(2));
        sberBank.addAccountToUser(thirdUser.getPassport(), accounts.get(3));
    }

    @Test
    public void whenAddUser() {
        sberBank.addUser(firstUser);
        sberBank.addUser(secondUser);
        sberBank.addUser(thirdUser);
        Set<User> result = new HashSet<>();
        result.add(sberBank.getUserByPassport("20 05 558346"));
        result.add(sberBank.getUserByPassport("37 05 033791"));
        result.add(sberBank.getUserByPassport("45 07 691152"));
        assertThat(result, is(new HashSet<>(List.of(firstUser, secondUser, thirdUser))));
    }

    @Test
    public void whenDeleteUser() {
        sberBank.addUser(firstUser);
        sberBank.addUser(secondUser);
        sberBank.addUser(thirdUser);
        sberBank.deleteUser(secondUser);
        Set<User> result = new HashSet<>();
        result.add(sberBank.getUserByPassport("20 05 558346"));
        result.add(sberBank.getUserByPassport("45 07 691152"));
        assertThat(result, is(new HashSet<>(List.of(firstUser, thirdUser))));
    }

    @Test
    public void whenAddAccountToUser() {
        List<Account> result = sberBank.getUserAccounts("20 05 558346");
        assertThat(result.get(0).getRequisites(), is("322153"));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        sberBank.deleteAccountFromUser("45 07 691152", accounts.get(3));
        List<Account> result = sberBank.getUserAccounts(thirdUser.getPassport());
        Assert.assertThat(result.size(), is(1));
    }

    @Test
    public void whenTransferMoneyBetweenAccounts() {
        sberBank.transferMoney("20 05 558346", "322153", "37 05 033791",
                "345823", 350.50);
        List<Account> resultSrc = sberBank.getUserAccounts("20 05 558346");
        List<Account> resultDest = sberBank.getUserAccounts("37 05 033791");
        assertThat(resultSrc.get(0).getValue(), is(500.0));
        assertThat(resultDest.get(0).getValue(), is(451.23));
    }
}