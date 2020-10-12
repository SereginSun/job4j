package ru.job4j.design.tictactoe;

/**
 * class RangeOutException.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class RangeOutException extends RuntimeException {
    public RangeOutException(String message) {
        super(message);
    }
}
