package ru.job4j.stream;

import java.util.Arrays;

/**
 * class StreamAPI.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.05.2019
 */
public class StreamAPI {
    /**
     * This method sums the squares of the even numbers of the integer array.
     *
     * @param array - Source integer array.
     * @return sum of squares of even elements of the array.
     */
    public int streamOperations(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .sum();
    }
}
