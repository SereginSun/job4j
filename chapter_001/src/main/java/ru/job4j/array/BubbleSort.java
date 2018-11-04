package ru.job4j.array;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 04.11.2018
 */
public class BubbleSort {
    /**
     * sort - метод, сортирующий массив целых чисел, используя алгоритм сортировки пузырьком.
     * @param array - входящий целочисленный массив.
     * @return отсортированный целочисленный массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
