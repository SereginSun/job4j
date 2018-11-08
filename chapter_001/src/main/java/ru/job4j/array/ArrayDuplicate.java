package ru.job4j.array;

import java.util.Arrays;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 08.11.2018
 */
public class ArrayDuplicate {
    /**
     * removeDuplicates - метод убирает все дубликаты строк из массива.
     * @param array массив строк с дубликатами.
     * @return массив строк без дубликатов.
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for(int out = 0; out < unique; out++) {
            for(int in = out + 1; in < unique; in++ ) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array,unique);
    }
}