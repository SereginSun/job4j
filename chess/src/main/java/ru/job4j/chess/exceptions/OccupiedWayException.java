package ru.job4j.chess.exceptions;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.01.2019
 */
public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException(String message) {
        super(message);
    }
}
