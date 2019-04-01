package ru.job4j.comparator;

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
}