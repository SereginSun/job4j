package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 04.11.2018
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] result = bubble.sort(new int[] {1, 5, 4, 2, 3, 8, 6, 7, 9, 0});
        assertThat(result, is(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

}