package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        int n = 5;
        int result = factorial.calc(n);
        assertThat(result, is(120));
    }
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int n = 5;
        int result = factorial.calc(n);
        assertThat(result, is(1));
    }
}