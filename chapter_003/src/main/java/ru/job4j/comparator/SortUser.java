package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * class SortUser
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 01.04.2019
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * The method sorts Users in the List by their name's length.
     * @param users List of users.
     * @return sorted List.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    /**
     * The method returns a list of users, sorted by both fields,
     * first sorted by name in lexicographical order, then by age.
     * @param users List of users.
     * @return sorted List.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return users;
    }
}