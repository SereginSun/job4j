package ru.job4j.comparator;

/**
 * class User
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 01.04.2019
 */
public class User implements Comparable<User> {
    private final String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" +
                age + "}";
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
}