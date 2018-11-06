package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 06.11.2018
 */
public class MatrixTest {
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}