package ru.job4j.array;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 01.11.2018
 */
public class Turn {
    /**
     * back - метод возвращающий перевёрнутый массив.
     * @param array - массив.
     * @return перевёрнутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
