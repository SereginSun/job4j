package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ValidateInputTest - тест для класса ValidateInput.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.01.2019
 */

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Пожалуйста, выберите пункт меню", range);
        assertThat(this.mem.toString(), is(String.format("Пожалуйста, введите номер позиции ещё раз.%n")));
    }

    @Test
    public void whenInInputOutOfMenu() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"Invalid", "-1", "1"}));
        List<Integer> range = new ArrayList<>();
        range.add(2);
        input.ask("Пожалуйста, выберите пункт меню", range);
        assertThat(this.mem.toString(), is(String.format("Пожалуйста, введите номер позиции ещё раз.%n")));
    }
}