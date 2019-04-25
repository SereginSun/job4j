package ru.job4j.bank;

/**
 * class User
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.04.2019
 */
public class User {
    private final String name;
    private final String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        return (o != null && getClass() == o.getClass() && this.passport.equals(((User) o).passport));
    }

    @Override
    public int hashCode() {
        return this.passport.hashCode();
    }
}