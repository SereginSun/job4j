package ru.job4j.design.menu;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class MenuTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.07.2020
 */
public class MenuTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenAddedMenuItemsThenShowsMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
        Menu menu = new Menu();
        menu.add(new Item("1.1."));
        menu.add(new Item("1."));
        menu.add(new Item("2."));
        menu.add(new Item("1.1.1."));
        menu.add(new Item("1.1.2."));
        menu.add(new Item("1.2.1."));
        menu.add(new Item("2.2."));
        menu.add(new Item("1.2."));
        menu.showMenu();
        String expected = Joiner.on(LN).join(
                "1.",
                "---1.1.",
                "------1.1.1.",
                "------1.1.2.",
                "---1.2.",
                "------1.2.1.",
                "2.",
                "---2.2.",
                ""
        );
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenChooseMenuItem() {
        Menu menu = new Menu();
        menu.add(new Item("1.1."));
        menu.add(new Item("1."));
        menu.add(new Item("2."));
        menu.add(new Item("1.1.1."));
        menu.add(new Item("1.1.2."));
        menu.add(new Item("1.2.1."));
        menu.add(new Item("2.2."));
        menu.add(new Item("1.2."));
        assertThat(menu.findBy("1.1.2."), is(true));
    }

    @Test
    public void whenChooseWrongMenuItem() {
        Menu menu = new Menu();
        menu.add(new Item("1.1."));
        menu.add(new Item("1."));
        menu.add(new Item("2."));
        menu.add(new Item("1.1.1."));
        menu.add(new Item("1.1.2."));
        menu.add(new Item("1.2.1."));
        menu.add(new Item("2.2."));
        menu.add(new Item("1.2."));
        assertThat(menu.findBy("1.1.4."), is(false));
    }

    @Test
    public void whenDeleteMenuItem() {
        Menu menu = new Menu();
        menu.add(new Item("1.1."));
        menu.add(new Item("1."));
        menu.add(new Item("2."));
        menu.add(new Item("1.1.1."));
        menu.add(new Item("1.1.2."));
        menu.add(new Item("1.2.1."));
        menu.add(new Item("2.2."));
        menu.add(new Item("1.2."));
        assertThat(menu.delete("1.1.2."), is(true));
    }

    @Test
    public void whenDeleteWrongMenuItem() {
        Menu menu = new Menu();
        menu.add(new Item("1.1."));
        menu.add(new Item("1."));
        menu.add(new Item("2."));
        menu.add(new Item("1.1.1."));
        menu.add(new Item("1.1.2."));
        menu.add(new Item("1.2.1."));
        menu.add(new Item("2.2."));
        menu.add(new Item("1.2."));
        assertThat(menu.delete("1.1.5."), is(false));
    }
}