package ru.job4j.statistics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * class AnalizeTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.07.2019
 */
public class AnalizeTest {
    private Analize statistic;
    private List<Analize.User> previous;

    @Before
    public void setUp() {
        statistic = new Analize();
        previous = List.of(
                new Analize.User(12456, "Макаров"),
                new Analize.User(32456, "Соловьёв"),
                new Analize.User(56234, "Яровой")
        );
    }

    @Test
    public void whenAddTwoUsersThenAdded2() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.addAll(List.of(
                new Analize.User(21356, "Антонов"),
                new Analize.User(42356, "Казаков")
        ));
        assertThat(statistic.diff(previous, current).added, is(2));
        assertThat(statistic.diff(previous, current).changed, is(0));
        assertThat(statistic.diff(previous, current).deleted, is(0));
    }

    @Test
    public void whenChangeTwoElementsThenCounter2() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.set(1, new Analize.User(32456, "Молчанов"));
        current.set(2, new Analize.User(56234, "Максимов"));
        assertThat(statistic.diff(previous, current).added, is(0));
        assertThat(statistic.diff(previous, current).changed, is(2));
        assertThat(statistic.diff(previous, current).deleted, is(0));
    }

    @Test
    public void whenDeleteElementThenDewleted1() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.remove(2);
        assertThat(statistic.diff(previous, current).added, is(0));
        assertThat(statistic.diff(previous, current).changed, is(0));
        assertThat(statistic.diff(previous, current).deleted, is(1));
    }
}