package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * class CalculatorTest
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.04.2019
 */
public class CalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(1, 4, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(2D, 5D, 10D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calculator calc = new Calculator();
        List<Double> result = calc.diapason(4, 7, Math::log);
        List<Double> expected = Arrays.asList(1.3862943611198906D, 1.6094379124341003D, 1.791759469228055D);
        assertThat(result, is(expected));
    }

}