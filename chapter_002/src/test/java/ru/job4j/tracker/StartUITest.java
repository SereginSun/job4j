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

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = new StringBuilder()
            //.append("Меню.")
            //.append(System.lineSeparator())
            .append("0. Добавить новую заявку.")
            .append(System.lineSeparator())
            .append("1. Показать список всех заявок.")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку.")
            .append(System.lineSeparator())
            .append("3. Удалить заявку.")
            .append(System.lineSeparator())
            .append("4. Найти заявку по ID.")
            .append(System.lineSeparator())
            .append("5. Найти заявку по названию.")
            .append(System.lineSeparator())
            .append("6. Выход из программы.")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new     StringBuilder()
                            .append(menu)
                            .append("------------ Добавление новой заявки ------------")
                            .append(System.lineSeparator())
                            .append("------------ Новая заявка с ID: " + tracker.findAll().get(0).getId())
                            .append(System.lineSeparator())
                            .toString()
                ));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                            .append(menu)
                            .append("------------ Редактирование заявки ------------")
                            .append(System.lineSeparator())
                            .append("Заявки с ID: " + item.getId() + " не существует.")
                            .append(System.lineSeparator())
                            .toString()
                ));
    }

    @Test
    public void whenDeleteItemThenNoMatchFound() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc", 123L));
        Item item2 = tracker.add(new Item("test123", "desc", 123L));
        Item item3 = tracker.add(new Item("test name3", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item2.getId(), "да"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                            .append(menu)
                            .append("------------ Удаление заявки ------------")
                            .append(System.lineSeparator())
                            .append("Заявки с ID: " + item2.getId() + " не существует.")
                            .append(System.lineSeparator())
                            .toString()
                ));
    }

    @Test
    public void whenFindItemByIdThenReturnValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name", "description", 123L));
        Input input = new StubInput(new String[]{"4", item.getId(), "да"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test name"));
    }

    @Test
    public void whenFindItemByNameThenReturnValue() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("Test name", "description", 123L));
        Item second = tracker.add(new Item("Test name", "description_1", 123L));
        Input input = new StubInput(new String[]{"5", "Test name", "да"});
        new StartUI(input, tracker).init();
        List<Item> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        assertThat(tracker.findByName("Test name"), is(expected));
    }
}