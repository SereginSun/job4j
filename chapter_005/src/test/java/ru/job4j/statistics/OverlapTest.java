package ru.job4j.statistics;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class OverlapTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 24.07.2019
 */
public class OverlapTest {

    @Test
    public void whenHaveTwoIntegerListsThenSetCrossing() {
        List<Integer> first = Arrays.asList(1, 2, 3);
        List<Integer> second = Arrays.asList(2, 3, 4);
        Set<Integer> result = new Overlap<Integer>().crossing(first, second);
        Set<Integer> expected = Set.of(2, 3);
        assertThat(result, is(expected));
    }
}