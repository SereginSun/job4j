package ru.job4j.design.tdd.cinema;

/**
 * class Ticket3D.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public class Ticket3D implements Ticket {
    private static final Ticket INSTANCE = new Ticket3D();

    private Ticket3D() {
    }

    public static Ticket getInstance() {
        return INSTANCE;
    }
}
