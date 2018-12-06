package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;


/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 05.12.2018
 */

public class TrackerTest {
    @Test
    public void whenAddItemThenTrackerItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item first = new Item(null,"test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item(null, "test2", "testDescription2", 123L);
        second.setId(first.getId());
        tracker.replace(first.getId(), second);
        assertThat(tracker.findById(second.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(null, "test1", "testDescription1", 123L);
        Item item2 = new Item(null, "test2", "testDescription2", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }
    @Test
    public void whenFindByNameThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findByName("test1"), is(item));
    }
    @Test
    public void whenCallFindByIdMethodThenTrackerGetItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(null, "task1", "this is 1 task", 123L);
        Item item2 = new Item(null, "task2", "this is 2 task", 123L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}