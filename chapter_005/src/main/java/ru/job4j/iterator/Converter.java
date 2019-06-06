package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * class Converter class Converter return iterator numerals.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 03.06.2019
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> innerIt = it.next();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !innerIt.hasNext()) {
                    innerIt = it.next();
                }
                return innerIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return innerIt.next();
            }
        };
    }
}
