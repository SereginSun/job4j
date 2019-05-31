package ru.job4j.iterator;

import java.util.Iterator;

/**
 * class MatrixIterator
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.05.2019
 */
public class MatrixIterator implements Iterator {
    private int size;
    private int position = 0;
    private int row = 0;
    private int column = 0;
    private final int[][] values;

    public MatrixIterator(final int[][] values) {
        this.size = countElement(values);
        this.values = values;
    }

    /**
     * The method counts the number of elements in the matrix.
     *
     * @param values - integer matrix.
     * @return number of elements in the matrix.
     */
    private int countElement(final int[][] values) {
        int count = 0;
        for (int[] row : values) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return size > position;
    }

    @Override
    public Object next() {
        Object element = values[row][column];
        position++;
        column++;
        while (row < values.length && column >= values[row].length) {
            column = 0;
            row++;
        }
        return element;
    }
}
