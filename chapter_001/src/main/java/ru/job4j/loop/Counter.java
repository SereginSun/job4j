package ru.job4j.loop;

/**
 * Counter
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @since 24.10.2018
 * @version 0.1
 */
public class Counter {
    int sum = 0;
    public int add(int start, int finish) {
        for(int index = start; index <= finish; index++) {
            if(index % 2 == 0) {
                sum += index;
            }
        }
        return sum;
    }
}
