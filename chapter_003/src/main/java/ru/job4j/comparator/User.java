package ru.job4j.comparator;

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
        final int result = this.age - o.age;
        return result != 0 ? result : this.name.compareTo(o.name);
    }
}