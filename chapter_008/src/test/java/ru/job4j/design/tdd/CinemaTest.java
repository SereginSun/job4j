package ru.job4j.design.tdd;

import org.junit.Test;
import ru.job4j.design.tdd.cinema.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        LocalDate date = LocalDate.of(2020, 11, 10);
        Ticket ticket = cinema.buy(account, 1, 2, date);
        assertThat(ticket, is(Ticket3D.getInstance()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(Session3D.getInstance());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(Session3D.getInstance())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBuyTicketWithWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        LocalDate date = LocalDate.of(2019, 11, 10);
        cinema.buy(account, 1, 2, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoFreePlaces() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        LocalDate date = LocalDate.of(2020, 11, 10);
        cinema.buy(account, 1, 1, date);
    }

    @Test
    public void whenFindThenNoSessions() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(0));
    }
}