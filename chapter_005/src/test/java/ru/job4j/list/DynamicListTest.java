package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class DynamicListTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru).
 * @version $Id$
 * @since 12.06.2019
 */
public class DynamicListTest {

    private DynamicList<Integer> list = new DynamicList<>();

    @Before
    public void setUp() {
        list.add(3);
        list.add(88);
        list.add(25);
        list.add(2);
        list.add(58);
    }

    @Test
    public void whenAddElementOverflowLengthThanCapacityGrows() {
        list.add(99);
        assertThat(list.size(), is(10));
    }

    @Test
    public void whenGetElementThanResult2() {
        assertThat(list.get(3), is(2));
    }

    @Test
    public void whenIteratorHasSequentialInvocation() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(88));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(25));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(58));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAfterChangesIteratorThrowsConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        list.add(77);
        iterator.next();
    }
}