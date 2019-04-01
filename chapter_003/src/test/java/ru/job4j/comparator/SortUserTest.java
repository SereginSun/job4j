package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for class SortUser
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 01.04.2019
 */
public class SortUserTest {

    /**
     * Test for sorting of Users by their age.
     */
    @Test
    public void whenSortedByAge() {
        SortUser testUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Scarlett", 34),
                new User("Vladimir", 32),
                new User("Nyusha", 28),
                new User("Arnold", 71),
                new User("Leonardo", 44)
                )
        );
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(
                new User("Vladimir", 32),
                new User("Scarlett", 34),
                new User("Arnold", 71),
                new User("Nyusha", 28),
                new User("Leonardo", 44)
                )
        );
        Set<User> result = testUser.sort(users);
        System.out.println(result);
        System.out.println(expected);
        assertThat(result, is(expected));
    }
}
