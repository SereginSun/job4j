package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class UserStoreTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class UserStoreTest {
    private final UserStore userStore = new UserStore(10);

    @Before
    public void init() {
        userStore.add(new User("1502"));
        userStore.add(new User("1808"));
        userStore.add(new User("1428"));
    }

    @Test
    public void whenReplaceUser() {
        assertThat(userStore.replace("1808", new User("1913")), is(true));
    }

    @Test
    public void whenDeleteUser() {
        assertThat(userStore.delete("1428"), is(true));
    }

    @Test
    public void whenFindById() {
        assertThat(userStore.findById("1502").equals(new User("1502")), is(true));
    }
}