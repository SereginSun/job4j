package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class MatrixTest.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 11.05.2019
 */
public class MatrixTest {

    @Test
    public void whenConvertArrayToList() {
        Integer[][] arrayTest = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> result = new Matrix().matrixToList(arrayTest);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }

}