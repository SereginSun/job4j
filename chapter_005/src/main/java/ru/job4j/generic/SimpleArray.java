package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class SimpleArray - universal wrapper over an array.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.06.2019
 */
public class SimpleArray<T> implements Iterable<T>{

    private T[] models;
    private int index = 0;

    public SimpleArray(int size) {
        this.models = (T[]) new Object[size];
    }

    public void add(T model) {
        if (this.index >= models.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.models[index++] = model;
    }

    public void set(int index, T model) {
        if (this.index > models.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.models[index] = model;
    }

    public void remove(int index) {
        System.arraycopy(this.models, index + 1, this.models, index, this.models.length - index - 1);
        this.index--;
    }

    public T get(int index) {
        return models[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < models.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return models[index++];
            }
        };
    }
}
