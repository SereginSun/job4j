package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for class ListCompare
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 02.04.2019
 */
public class ListCompareTest {

    private final ListCompare compare = new ListCompare();

    @Test
    public void whenStringsAreEqualThenZero() {
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightResultShouldBePositive() {
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightResultShouldBeNegative() {
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result, lessThan(0));
    }
}