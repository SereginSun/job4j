package ru.job4j.comparator;

import org.junit.Before;
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

    private final SortUser testUser = new SortUser();
    private final List<User> users = new ArrayList<>();
    private final List<User> expected = new ArrayList<>();

    @Before
    public void initialArrays() {
        users.add(new User("Scarlett", 34));
        users.add(new User("Vladimir", 32));
        users.add(new User("Nyusha", 28));
        users.add(new User("Arnold", 71));
        users.add(new User("Leonardo", 44));
    }

    /**
     * Test for sorting of Users by their age.
     */
    @Test
    public void whenSortedByAge() {
        expected.add(new User("Nyusha", 28));
        expected.add(new User("Vladimir", 32));
        expected.add(new User("Scarlett", 34));
        expected.add(new User("Leonardo", 44));
        expected.add(new User("Arnold", 71));
        System.out.println(testUser.sort(users));
        System.out.println(expected);
        assertThat(testUser.sort(users).toString(), is(expected.toString()));
    }

    /**
     * Test for sorting of Users by the Length of their Name.
     */
    @Test
    public void whenSortedByLength() {
        expected.add(new User("Nyusha", 28));
        expected.add(new User("Arnold", 71));
        expected.add(new User("Scarlett", 34));
        expected.add(new User("Vladimir", 32));
        expected.add(new User("Leonardo", 44));
        System.out.println(testUser.sortNameLength(users));
        System.out.println(expected);
        assertThat(testUser.sortNameLength(users).toString(), is(expected.toString()));
    }

    /**
     * Test for sorting of Users by their Name lexicographically and then by their Age.
     */
    @Test
    public void whenSortedByAllFields() {
        users.add(new User("Vladimir", 15));

        expected.add(new User("Arnold", 71));
        expected.add(new User("Leonardo", 44));
        expected.add(new User("Nyusha", 28));
        expected.add(new User("Scarlett", 34));
        expected.add(new User("Vladimir", 15));
        expected.add(new User("Vladimir", 32));
        System.out.println(testUser.sortByAllFields(users));
        System.out.println(expected);
        assertThat(testUser.sortByAllFields(users).toString(), is(expected.toString()));
    }
}
