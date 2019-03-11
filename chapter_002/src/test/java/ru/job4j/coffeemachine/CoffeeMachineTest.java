package ru.job4j.coffeemachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 11.03.2019
 */
public class CoffeeMachineTest {

    @Test
    public void whenValue50andPrice35ThenSmallChange15() {
        CoffeeMachine money = new CoffeeMachine();
        int[] result = money.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenValue100andPrice63ThenSmallChange37() {
        CoffeeMachine money = new CoffeeMachine();
        int[] result = money.changes(100, 63);
        int[] expect = {10, 10, 10, 5, 2};
        assertThat(result, is(expect));
    }

}