package ru.job4j.statistics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class Overlap
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 24.07.2019
 */
public class Overlap<E> {

    public Set<E> crossing(List<E> a, List<E> b) {
        Set<E> allSet = new HashSet<>();
        Set<E> crossSet = new HashSet<>();
        for (var value : a) {
            allSet.add(value);
        }
        for (var value : b) {
            if (allSet.contains(value)) {
                crossSet.add(value);
            }
        }
        return crossSet;
    }
}
