package ru.job4j.array;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 06.11.2018
 */
public class Matrix {
    /**
     * multiple - метод, создающий таблицу умножения.
     * @param size - целочисленный размер таблицы умножения.
     * @return table - полученная таблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
