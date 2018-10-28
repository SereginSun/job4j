package ru.job4j.loop;
import java.util.function.BiPredicate;
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
        return this.loopBy(hieght, hieght, (row, column) -> row >= column);
    }

    /**
     * leftTrl - метод, рисующий половину пирамиды слева.
     * @param hieght - высота пирамиды.
     * @return буфер строки.
     */
    public String leftTrl(int hieght) {
        return this.loopBy(hieght, hieght, (row, column) -> row >= column - 1);
    }

    /**
     * pyramid - метод рисующий пирамиду.
     * @param hieght - высота пирамиды.
     * @return буфер строки.
     */
    public String pyramid(int hieght) {
        return this.loopBy(hieght, 2 * hieght - 1, (row, column) -> row >= hieght - column - 1 && row + hieght -1 >= column);
    }

    private String loopBy(int hieght, int width, BePredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for(int row = 0; row != hieght; row++) {
            for(int column = 0; column != width; column++) {
                if(predict.test(row, column)) {
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
