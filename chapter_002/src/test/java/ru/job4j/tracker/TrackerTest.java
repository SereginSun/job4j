package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;


/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 05.12.2018
 */

public class TrackerTest {
    @Test
    public void whenAddItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 123L);
        second.setId(first.getId());
        tracker.replace(first.getId(), second);
        assertThat(tracker.findById(second.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }
    @Test
    public void whenFindByNameThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test1", "testDescription2", 123L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 123L);
        tracker.add(third);
        List<Item> itemsExpected = new ArrayList<>();
        itemsExpected.add(first);
        itemsExpected.add(second);
        assertThat(tracker.findByName("test1"), is(itemsExpected));
    }
    @Test
    public void whenCallFindByIdMethodThenTrackerGetItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("task1", "this is 1 task", 123L);
        Item item2 = new Item("task2", "this is 2 task", 123L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}