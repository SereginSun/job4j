package ru.job4j.loop;

/**
 * Counter
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.2
 * @since 25.10.2018
 */
public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        for (int index = start; index <= finish; index++)
            if (index % 2 == 0) {
                sum += index;
            }
        return sum;
    }
}
