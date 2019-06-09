package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class RoleStoreTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class RoleStoreTest {
    private final RoleStore roleStore = new RoleStore(10);

    @Before
    public void init() {
        roleStore.add(new Role("2176"));
        roleStore.add(new Role("2620"));
        roleStore.add(new Role("2355"));
    }

    @Test
    public void whenReplaceUser() {
        assertThat(roleStore.replace("2620", new Role("2695")), is(true));
    }

    @Test
    public void whenDeleteUser() {
        assertThat(roleStore.delete("2355"), is(true));
    }

    @Test
    public void whenFindById() {
        assertThat(roleStore.findById("2176").equals(new Role("2176")), is(true));
    }

}