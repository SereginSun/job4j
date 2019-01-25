package ru.job4j.Singleton;

import ru.job4j.tracker.Item;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public interface TrackerSingleInterface {

    Item add(Item item);

    Item[] findAll();

    boolean delete(String id);

    boolean replace(String id, Item item);

    Item findById(String id);

    Item[] findByName(String key);
}
