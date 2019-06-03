package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class MatrixIterator
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.05.2019
 */
public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int row = 0;
    private int column = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.row < this.values.length && this.column < this.values[row].length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object element = values[row][column];
        column++;
        if (this.column >= this.values[row].length) {
            column = 0;
            row++;
        }
        return element;
    }
}
