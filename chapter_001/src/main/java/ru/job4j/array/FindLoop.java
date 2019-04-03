package ru.job4j.array;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class FindLoop {
    /**
     * indexOf - метод поиска элемента в массиве.
     * @param data - входящий массив.
     * @param el - искомое значение.
     * @return  индекс искомого значения.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
            for (int index = 0; index < data.length; index++) {
                if (data[index] == el) {
                    rst = index;
                    break;
                }
            }
            return rst;
    }
}
