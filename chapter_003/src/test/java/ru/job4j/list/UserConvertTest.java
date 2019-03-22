package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for class UserConvert
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 22.03.2019
 */
public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();
        users.add(new User(77, "Veronika", "Berlin"));
        users.add(new User(189, "Vladimir", "Voronezh"));
        users.add(new User(21, "Roman", "Moscow"));
        HashMap<Integer, User> result = convert.process(users);
        assertThat(result.get(189).getName(), is("Vladimir"));
        assertThat(result.get(77).getCity(), is("Berlin"));
    }
}