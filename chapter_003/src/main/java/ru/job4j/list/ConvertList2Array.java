package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * class ConvertList2Array
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 20.03.2019
 */
public class ConvertList2Array {

    /**
     * The method toArray() takes a list of values and converts them into a two-dimensional array.
     * @param list list of type Integer.
     * @param rows number of columns.
     * @return two-dimensional array of int type.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int index : list) {
            array [i][j++] = index;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        return array;
    }

    /**
     * The method convert() go through all the elements
     * of all the arrays in the list and add them
     * to one common list Integer.
     * @param list list of arrays
     * @return list of Integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }
}
