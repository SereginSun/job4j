package ru.job4j.design.tdd;

import org.junit.Test;
import ru.job4j.design.tdd.cinema.*;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * class CinemaTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.08.2020
 */
public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(new Session3D())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketWithWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2019, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoFreePlaces() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2019, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void whenFindThenNoSessions() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(0));
    }
}