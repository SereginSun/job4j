package ru.job4j.list;

/**
 * class SimpleStack, based on linked list.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 16.06.2019
 */
public class SimpleStack<E> {
    private SimpleArrayList<E> list = new SimpleArrayList<>();

    /**
     * This method returns the value and remove it from the container.
     * @return deleted value.
     */
    public E poll() {
        return list.delete();
    }

    /**
     * This method puts the value in a container.
     * @param value - this value is placed in a container.
     */
    public void push(E value) {
        list.add(value);
    }
}