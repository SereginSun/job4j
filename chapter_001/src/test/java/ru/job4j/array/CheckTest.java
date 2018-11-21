package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Test
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 01.11.2018
    */
public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check verification = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = verification.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueThenTrue() {
        Check verification = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = verification.mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check verification = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = verification.mono(input);
        assertThat(result, is(true));
    }
}