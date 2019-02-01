package ru.job4j.chess.exceptions;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.01.2019
 */
public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException(String message) {
        super(message);
    }
}
