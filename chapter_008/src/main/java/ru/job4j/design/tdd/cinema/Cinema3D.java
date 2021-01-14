package ru.job4j.design.tdd.cinema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * class Cinema3D.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public class Cinema3D implements Cinema {
    List<Session> sessions = new ArrayList<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return sessions.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public Ticket buy(Account account, int row, int column, LocalDate date) {
        boolean[][] places = {{false, true}, {true, true}};
        if (date.isBefore(LocalDate.of(2020, Calendar.AUGUST, 10)) || !places[row - 1][column - 1]) {
            throw new IllegalArgumentException("Wrong data.");
        }
        places[row - 1][column - 1] = false;
        return Ticket3D.getInstance();
    }

    @Override
    public void add(Session session) {
        sessions.add(session);
    }
}
