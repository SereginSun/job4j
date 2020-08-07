package ru.job4j.design.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

/**
 * interface Cinema.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public interface Cinema {

    /**
     * The method searches for movie sessions by filter.
     * @param filter - session predicate.
     * @return list of sessions.
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Buying a ticket.
     * @param account - user account.
     * @param row - hall row.
     * @param column - row seat number.
     * @param date - date of the session.
     * @return object Ticket.
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * Session adding method.
     * @param session film session.
     */
    void add(Session session);
}
