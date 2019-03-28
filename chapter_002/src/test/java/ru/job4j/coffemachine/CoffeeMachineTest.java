package ru.job4j.coffemachine;

import org.junit.Test;
import ru.job4j.coffeemachine.CoffeeMachine;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 09.03.2019
 */
public class CoffeeMachineTest {

    @Test
    public void whenValue50andPrice35ThenSmallChange15() {
        CoffeeMachine money = new CoffeeMachine();
        int[] result = money.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(result, is(expect));
    }
}