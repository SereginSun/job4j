package ru.job4j.loop;
/**
 * Counter
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.2
 * @since 25.10.2018
 */
public class Counter {
    /**
     * add - метод, вычисляющий сумму в диапазоне от start до finish.
     * @param start первое значение диапазона.
     * @param  finish последнее значение диапазона.
     * @return суммы.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                sum += index;
            }
        }
        return sum;
    }
}
