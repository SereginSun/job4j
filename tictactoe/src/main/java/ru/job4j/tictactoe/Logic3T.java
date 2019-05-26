package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * class Logic3T - tic-tac-toe logic class
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.05.2019
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * This method checks whether a row / column / diagonal is filled with crosses(X) or zeroes(O).
     *
     * @param predicate - Predicate for a cross or a zero, which is a parameterized behavior,
     * since we have two events: a check for a cross and a zero.
     * @param startX - The initial value of the X coordinate.
     * @param startY - The initial value of the Y coordinate.
     * @param deltaX - Direction of change X coordinate.
     * @param deltaY - Direction of change Y coordinate.
     * @return true - if the row / column / diagonal is filled with crosses or zeros, else false.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * The method checks the presence of winning combinations.
     *
     * @param predicate - Predicate for a cross or a zero, which is a parameterized behavior,
     * since we have two events: a check for a cross and a zero.
     * @return true - there is a winning combination, else false.
     */
    public boolean isWinner(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 1, 0, 0, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 0, this.table.length - 1, 1, 0)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
    }

    /**
     * The method checks if there are any winning combinations for the crosses(X).
     *
     * @return true - if the crosses(X) won, else false.
     */
    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    /**
     * The method checks if there are any winning combinations for the zeroes(O).
     *
     * @return true - if the zeroes(O) won, else false.
     */
    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    /**
     * The method checks if there are free cells.
     *
     * @return true - if there are free cells, else false.
     */
    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .anyMatch(figure -> !figure.hasMarkX() && !figure.hasMarkO());
    }
}
