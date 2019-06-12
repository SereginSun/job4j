package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class Dynamic array based.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.06.2019
 */
public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    private static final int defaultSize = 5;
    private int position;
    private int modCount;

    /**
     * Constructs an empty list with the specified initial capacity.
     */
    public DynamicList() {
        this.container = new Object[defaultSize];
        this.position = 0;
        this.modCount = 0;
    }

    /**
     * This method adds value to the container.
     *
     * @param value - value added to container.
     */
    public void add(E value) {
        modCount++;
        if (this.position >= this.container.length) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
        this.container[position++] = value;
    }

    /**
     * This method returns an array element by his index.
     *
     * @param index - index of element.
     * @return array element at index
     */
    public E get(int index) {
        if (index >= this.position) {
            throw new NoSuchElementException();
        }
        return (E) this.container[index];
    }

    /**
     * This method returns the size of the container.
     * @return the size of the container.
     */
    public int size() {
        return this.container.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int iterCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (iterCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[index++];
            }
        };
    }
}
