package ru.job4j.loop;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 28.10.2018
 */
public class Paint {
    /**
     * rightTrl - метод, рисующий половину пирамиды справа.
     * @param hieght - высота пирамиды.
     * @return буфер строки.
     */
    public String rightTrl(int hieght) {
        StringBuilder screen = new StringBuilder();
        int width = hieght;
        for (int row = 0; row != hieght; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * leftTrl - метод, рисующий половину пирамиды слева.
     * @param hieght - высота пирамиды.
     * @return буфер строки.
     */
    public String leftTrl(int hieght) {
        StringBuilder screen = new StringBuilder();
        int width = hieght;
        for (int row = 0; row != hieght; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * pyramid - метод рисующий пирамиду.
     * @param hieght - высота пирамиды.
     * @return буфер строки.
     */
    public String pyramid(int hieght) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * hieght - 1;
        for(int row = 0; row != hieght; row++) {
            for(int column = 0; column != width; column++ ) {
                if(row >= hieght - column - 1 && row + hieght - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
