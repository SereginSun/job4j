package ru.job4j.post;

import java.util.Set;

/**
 * class User
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.10.2019
 */
public class User {
    private String name;
    private Set<String> email;

    public User(String name, Set<String> email) {
        this.name = name;
        this.email = email;
    }

    public Set<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", email=" + email
                + '}';
    }
}