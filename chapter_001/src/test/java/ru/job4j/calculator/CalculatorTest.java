package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D,1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenThreeSubtractTwoThenOne() {
        Calculator calc = new Calculator();
            calc.subtract(3D,2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenFourDivTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D,2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenThreeMultipleThreeThenNine() {
        Calculator calc = new Calculator();
        calc.multiple(3D,3D);
        double result = calc.getResult();
        double expected = 9D;
        assertThat(result,is (expected));

    }
}

