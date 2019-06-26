package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class UserTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.06.2019
 */
public class UserTest {
    private User first = new User("Roman", 1, new GregorianCalendar(2016, 10, 20));
    private User second = new User("Roman", 1, new GregorianCalendar(2016, 10, 20));

    @Test
    public void whenEqualsAndHashCodeAreNotOverriden() {
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first son");
        map.put(second, "second son");
        assertThat(first.equals(second), is(false));
    }
}