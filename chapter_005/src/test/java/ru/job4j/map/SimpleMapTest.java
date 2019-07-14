package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class SimpleMapTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.07.2019
 */
public class SimpleMapTest {
    private SimpleMap<String, String> map;

    @Before
    public void  setUp() {
        map = new SimpleMap<>();
        map.insert("first", "one");
        map.insert("second", "two");
        map.insert("third", "three");
    }

    @Test
    public void whenAddPairThanGetNewValue() {
        map.insert("fourth", "four");
        assertThat(map.get("fourth"), is("four"));
    }

    @Test
    public void whenAddEqualsKeysThanValueWillRecording() {
        map.insert("second", "twenty two");
        assertThat(map.get("second"), is("twenty two"));
    }

    @Test
    public void whenAddTwoPairThanSize5() {
        map.insert("fourth", "four");
        map.insert("fifth", "five");
        assertThat(map.size(), is(5));
    }

    @Test
    public void whenDeletePairByKeyThanSize4() {
        map.insert("fourth", "four");
        map.insert("fifth", "five");
        map.delete("second");
        assertThat(map.size(), is(4));
    }

    @Test
    public void whenAdd13PairThanArrayIncrease() {
        map.insert("fourth", "four");
        map.insert("fifth", "five");
        map.insert("sixth", "six");
        map.insert("seventh", "seven");
        map.insert("eighth", "eight");
        map.insert("ninth", "nine");
        map.insert("tenth", "ten");
        map.insert("eleventh", "eleven");
        map.insert("twelfth", "twelve");
        map.insert("thirteenth", "thirteen");
        assertThat(map.size(), is(13));
    }

    @Test
    public void whenIteratorShouldReturnThreePair() {
        Iterator<String> iter = map.iterator();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }
}