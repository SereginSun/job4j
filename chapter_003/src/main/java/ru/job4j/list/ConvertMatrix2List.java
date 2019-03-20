package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * class ConvertMatrix2List
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 20.03.2019
 */
public class ConvertMatrix2List {

    /**
     * method toList() convert a two-dimensional array to an ArrayList
     * @param array a two-dimensional array
     * @return list
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int [] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
