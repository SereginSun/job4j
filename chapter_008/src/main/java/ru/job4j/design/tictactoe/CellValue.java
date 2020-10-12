package ru.job4j.design.tictactoe;

/**
 * class Cell.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public enum CellValue {

    EMPTY(' '),
    HUMAN('X'),
    CPU('O');

    private final char value;

    CellValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
