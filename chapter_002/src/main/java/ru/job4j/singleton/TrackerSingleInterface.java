package ru.job4j.singleton;

import ru.job4j.tracker.Item;

import java.util.List;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public interface TrackerSingleInterface {

    Item add(Item item);

    List<Item> findAll();

    boolean delete(String id);

    boolean replace(String id, Item item);

    Item findById(String id);

    List<Item> findByName(String key);
}
