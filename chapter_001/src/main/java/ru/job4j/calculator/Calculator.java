package ru.job4j.calculator;
/**
 * Calculator - this is a class of simple arithmetic operations
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
     * method add
     *
     * метод скложения
     *
     * @param first - this is the first parametr
     *
     * @param second - this is the second parametr
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     *  method getResult
     *
     * метод возвращает значение поля result.
     *
     */
    public double getResult() {
        return this.result;
    }
    /**
     * method subtract
     *
     * разница
     *
     * @param first - this is the first parametr
     *
     * @param second - this is the second parametr
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * method div
     *
     * частное
     *
     * @param first - this is the first parametr
     *
     * @param second - this is the second parametr
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * method multiple
     *
     * произведение параметров first и second
     *
     * @param first - this is the first parametr
     *
     * @param second - this is the second parametr
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
