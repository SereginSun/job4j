package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        /**
         * создаём Tracker
         */
        Tracker tracker = new Tracker();
        /**
         * создаём StubInput с последовательностью действий
         */
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        /**
         * создаём StartUI и вызываем метод init()
         */
        new StartUI(input, tracker).init();
        /**
         * проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
         */
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        /**
         * создаём Tracker
         */
        Tracker tracker = new Tracker();
        /**
         * Напрямую добавляем заявку
         */
        Item item = tracker.add(new Item("test name", "desc", 123L));
        /**
         * создаём StubInput с последовательностью действий (производим замену заявки)
         */
        Input input = new StubInput(new String[] {"2", item.getId(), "test replace", "заменили заявку", "6"});
        /**
         * создаём StartUI и вызываем метод init()
         */
        new StartUI(input, tracker).init();
        /**
         * проверяем, что элемент массива в трекере содержит имя, введёное при эмуляции.
         */
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenNoMatchFound() {
        /**
         * создаём Tracker
         */
        Tracker tracker = new Tracker();
        /**
         * Напрямую добавляем заявки
         */
        Item item1 = tracker.add(new Item("test name", "desc", 123L));
        Item item2 = tracker.add(new Item("test123", "desc", 123L));
        Item item3 = tracker.add(new Item("test name3", "desc", 123L));

        /**
         * создаём StubInput с последовательностью действий (производим удалении заявки с индексом 1)
         */
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        /**
         * создаём StartUI и вызываем метод init()
         */
        new StartUI(input, tracker).init();
        /**
         * проверяем, что элемент массива в трекере с индексом 1, это элемент, который ранее был с индексом 2.
         */
        assertThat(tracker.findAll()[1].getName(), is("test name3"));
    }

    @Test
    public void whenFindItemByIdThenReturnValue() {
        /**
         * создаём Tracker
         */
        Tracker tracker = new Tracker();
        /**
         * Напрямую добавляем заявки
         */
        Item item = tracker.add(new Item("Test name", "description", 123L));
        /**
         * создаём StubInput с последовательностью действий (производится поиск заявок по ID).
         */
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        /**
         * создаём StartUI и вызываем метод init()
         */
        new StartUI(input, tracker).init();
        /**
         * проверяем, что элемент массива в трекере содержит имя, введёное при эмуляции.
         */
        assertThat(tracker.findById(item.getId()).getName(), is("Test name"));
    }

    @Test
    public void whenFindItemByNameThenReturnValue() {
        /**
         * создаём Tracker
         */
        Tracker tracker = new Tracker();
        /**
         * Напрямую добавляем заявки
         */
        Item first = tracker.add(new Item("Test name", "description", 123L));
        Item second = tracker.add(new Item("Test name", "description_1", 123L));
        /**
         * создаём StubInput с последовательностью действий (производим писк заявок по имени).
         */
        Input input = new StubInput(new String[]{"5", "Test name", "6"});
        /**
         * создаём StartUI и вызываем метод init()
         */
        new StartUI(input, tracker).init();
        /**
         * проверяем, что элемент массива в трекере содержит имя, введёное при эмуляции.
         */
        assertThat(tracker.findByName("Test name"), is(new Item[]{first, second}));
    }
}