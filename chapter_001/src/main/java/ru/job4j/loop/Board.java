package ru.job4j.loop;

/**
 * Board - класс, строящий шахматную доску в псевдографике.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru).
 * @version 0.1
 * @since 25.10.2018
 */
public class Board {
    /**
     * paint - метод, рисующий шахматную доску.
     * @param weight - ширина доски.
     * @param height - высота доски
     * @return screen - возвращаемое строковое представление доски.
     */
    public String paint(int weight, int height) {
        StringBuilder screen = new StringBuilder();
        String line = System.getProperty("line.separator");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if ((i+j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
        }
        return screen.toString();
    }
}
