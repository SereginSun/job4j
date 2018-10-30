package ru.job4j.array;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class Square {
    /**
     * calculate - метод, возвращающий массив, заполненый числами, возведёнными в квадрат.
     * @param bound - количество элементов массива.
     * @return rst - массив, заполненый числами, возведёнными в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for(int index = 1; index <= bound; index++) {
            rst[index - 1 ] = index * index;
        }
        return rst;
    }
}
