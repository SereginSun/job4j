package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * class Calculator
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.04.2019
 */
public class Calculator {

    /**
     * The method calculates mathematical functions in a diapason.
     * @param start - the initial value of the diapason (inclusive).
     * @param end - diapason end value.
     * @param func - Mathematical function for calculation.
     * @return List of values of calculated function.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
