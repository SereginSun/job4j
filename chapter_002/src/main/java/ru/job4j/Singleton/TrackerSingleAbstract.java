package ru.job4j.Singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public abstract class TrackerSingleAbstract implements TrackerSingleInterface {

    private Tracker tracker = new Tracker();

    @Override
    public Item add(Item item) {
        return this.tracker.add(item);
    }

    @Override
    public Item[] findAll() {
        return this.tracker.findAll();
    }

    @Override
    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    @Override
    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    @Override
    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    @Override
    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }
}
