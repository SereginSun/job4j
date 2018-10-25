package ru.job4j.loop;

/**
 * Factorial
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.2
 * @since 25.10.2018
 */
public class Factorial {

    /**
     * calc
     *
     * @param n конечное число
     * @return результат
     */
    public int calc(int n) {
        int fact = 1;
        for (int index = 1; index <= n; index++) {
            fact *= index;
        }
        return fact;
    }
}
