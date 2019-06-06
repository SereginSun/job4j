package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class SimpleArrayTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.06.2019
 */
public class SimpleArrayTest {

    @Test
    public void whenCreatedContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> simple = new SimpleArray<>(4);
        simple.add(2);
        int result = simple.get(0);
        assertThat(result, is(2));
    }

    @Test
    public void whenSetNewStringContainerShouldReturnChangedArray() {
        SimpleArray<String> simple = new SimpleArray<>(3);
        simple.add("first");
        simple.add("second");
        simple.add("third");
        simple.set(1, "intermediate");
        String result = simple.get(1);
        assertThat(result, is("intermediate"));
    }

    @Test
    public void whenRemoveElementThanSizeOfArray2() {
        SimpleArray<Double> simple = new SimpleArray<>(3);
        simple.add(2.1);
        simple.add(3.8);
        simple.add(1.7);
        simple.remove(1);
        Double result = simple.get(1);
        assertThat(result, is(1.7));
    }

    @Test
    public void whenSequentialInvocation() {
        SimpleArray<Integer> simple = new SimpleArray<>(3);
        simple.add(0);
        simple.add(1);
        simple.add(2);
        Iterator<Integer> it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementThanThrowArrayOverFlowException() {
        SimpleArray<Integer> simple = new SimpleArray<>(2);
        simple.add(0);
        simple.add(1);
        simple.add(2);
    }
}