package ru.job4j.calculator;
/**
 * Calculator
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *
 * @version 1.0.1
 *
 * @since 09.10.2018
 */
public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }
    public double getResult() {
        return this.result;
    }
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    public void div(double first, double second) {
        this.result = first / second;
    }
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
