package ru.job4j.set;

import ru.job4j.list.DynamicList;
import java.util.Iterator;

/**
 * class SimpleSet, based on array.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 18.06.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    private DynamicList<E> list = new DynamicList<>();

    /**
     * This method adds a unique item to the collection.
     *
     * @param value - the value we want to add.
     */
    public void add(E value) {
        if (!contains(value)) {
            this.list.add(value);
        }
    }

    /**
     * This method checks if there is a duplicate in the collection.
     *
     * @param value - the value we want to add.
     * @return true if duplicate is exist, false - otherwise.
     */
    public boolean contains(E value) {
        boolean result = false;
        for (E element : list) {
            if (value.equals(element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}