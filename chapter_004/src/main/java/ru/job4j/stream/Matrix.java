package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class Matrix.
 * Implements the method of converting a matrix into a list.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 11.05.2019
 */
public class Matrix {

    /**
     * This method converts a matrix to a List.
     *
     * @param input - two-dimensional integer array.
     * @return - integer List.
     */
    public List<Integer> matrixToList(Integer[][] input) {
        return Arrays.stream(input).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
