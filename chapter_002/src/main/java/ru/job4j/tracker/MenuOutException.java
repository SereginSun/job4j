package ru.job4j.tracker;

/**
 * MenuOutException.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 15.01.2019
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
