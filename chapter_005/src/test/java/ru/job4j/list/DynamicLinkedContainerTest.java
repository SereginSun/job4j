package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class DynamicLinkedContainerTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru).
 * @version $Id$
 * @since 12.06.2019
 */
public class DynamicLinkedContainerTest {

    private DynamicLinkedContainer<String> list = new DynamicLinkedContainer<>();

    @Before
    public void setUp() {
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
    }

    @Test
    public void whenGetElementThanResult() {
        assertThat(list.get(0), is("fifth"));
    }

    @Test
    public void whenIteratorHasSequentialInvocation() {
        Iterator<String> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("fifth"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("fourth"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("third"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("second"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAfterChangesIteratorThrowsConcurrentModificationException() {
        Iterator<String> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("fifth"));
        list.add("sixth");
        iterator.next();
    }
}