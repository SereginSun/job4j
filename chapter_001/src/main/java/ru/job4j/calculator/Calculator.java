package ru.job4j.calculator;

/**
 * Calculator - this is a class of simple arithmetic operations.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *
 * @version 1.0.1
 *
 * @since 09.10.2018
 */
public class Calculator {
    private double result;

    /**
     * method add - метод сложения.
     *
     * @param first - this is the first parameter.
     *
     * @param second - this is the second parameter.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     *  method getResult - метод возвращает значение поля result.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * method subtract - вычитание.
     *
     * @param first - this is the first parameter.
     *
     * @param second - this is the second parameter.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * method div - деление.
     *
     * @param first - this is the first parameter.
     *
     * @param second - this is the second parameter.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * method multiple - произведение параметров first и second.
     *
     * @param first - this is the first parameter.
     *
     * @param second - this is the second parameter.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
