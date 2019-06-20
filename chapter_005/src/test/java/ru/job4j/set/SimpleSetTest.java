package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SimpleSetTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.06.2019
 */
public class SimpleSetTest {

    @Test
    public void whenIteratorHasSequentialInvocation() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("second");
        set.add("first");
        set.add("third");
        Iterator<String> iter = set.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("first"));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("second"));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is("third"));
        assertThat(iter.hasNext(), is(false));
    }
}