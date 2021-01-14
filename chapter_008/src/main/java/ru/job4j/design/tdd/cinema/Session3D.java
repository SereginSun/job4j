package ru.job4j.design.tdd.cinema;

/**
 * class Session3D.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public class Session3D implements Session {
    private static final Session INSTANCE = new Session3D();

    private Session3D() {
    }

    public static Session getInstance() {
        return INSTANCE;
    }
}
