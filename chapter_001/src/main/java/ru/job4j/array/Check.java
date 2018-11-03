package ru.job4j.array;
/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 01.11.2018
 */
public class Check {
    /**
     * mono - метод, проверяющий, что все элементы в массиве либо true, либо false/
     * @param data входящий массив логического типа.
     * @return результат логической операции: либо true, либо false/
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1] ) {
                return false;
            }
        }
        return true;
    }
}
