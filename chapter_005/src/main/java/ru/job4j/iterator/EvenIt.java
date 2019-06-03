package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class EvenIt implements iterator returning even numbers only.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 03.06.2019
 */
public class EvenIt implements Iterator {
    private final int[] numbers;
    private int position = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int index = this.position; index != numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                result = true;
                this.position = index;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[this.position++];
    }
}
