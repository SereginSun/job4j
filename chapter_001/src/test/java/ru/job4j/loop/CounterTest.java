package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThirty() {
        Counter enumerator = new Counter();
        int start = 1;
        int finish = 10;
        int result = enumerator.add(start, finish);
        assertThat(result, is(30));
    }
}