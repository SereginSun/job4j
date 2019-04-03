package ru.job4j.array;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 06.11.2018
 */
public class MatrixCheck {
    /**
     * mono - метод, проверяющий, что все элементы по диагоналям равны либо true, либо false.
     * @param data - входящий массив, содержащий true или false.
     * @return результат проверки диагоналей.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index <= data.length - 1; index++) {
            if (data[index][index] != data[0][0]) {
                result = false;
                break;
            }
            if (data[index][data.length - index - 1] != data[0][data.length - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
