package ru.job4j.loop;
/**
 * Factorial
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @since 24.10.2018
 * @version 0.1
 */
public class Factorial {
    int fact = 0;

    /**
     * calc
     *
     * @param n конечное число
     * @return результат
     */
    public int calc(int n) {
        for(int index = 0; index <= n; index++) {
            fact *= index;
            if(index == 0) {
                fact = 1;
            }
        } return fact;
    }
}
