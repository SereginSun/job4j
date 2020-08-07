package ru.job4j.design.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * class Cinema3D.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public class Cinema3D implements Cinema {

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {
    }
}
