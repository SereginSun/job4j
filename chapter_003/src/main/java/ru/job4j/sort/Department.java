package ru.job4j.sort;

import java.util.*;

/**
 * class Department, where each line has the following structure:
 * each line includes the code of this department,
 * as well as all the codes of departments,
 * which include this department in its structure.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.04.2019
 */
public class Department {

    /**
     * This method adds the missing lines with the code of the top level unit.
     *
     * @param list to add new lines departmens.
     */
    public void addDepartment(List<String> list) {
        for (int out = 0; out < list.size(); out++) {
            String[] separated = list.get(out).split("\\\\");
            if (separated.length > 1) {
                String temp = separated[0];
                for (int in = 1; in < separated.length; in++) {
                    if (!list.contains(temp)) {
                        list.add(temp);
                    }
                    temp += "\\" + separated[in];
                }
            }
        }
    }

    /**
     * The method provides ascending sorting operation.
     *
     * @param list - list of division codes.
     */
    public void ascendingSort(List<String> list) {
        addDepartment(list);
        list.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
    }

    /**
     * The method provides descending sorting operation.
     *
     * @param list - list of division codes.
     */
    public void descendingSort(List<String> list) {
        addDepartment(list);
        list.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int result = Integer.compare(o1.length(), o2.length());
                        int minLength = o1.length() > o2.length() ? o2.length() : o1.length();
                        for (int i = 0; i < minLength; i++) {
                            int count = Character.compare(o2.charAt(i), o1.charAt(i));
                            if (count != 0) {
                                result = count;
                                break;
                            }
                        }
                        return result;
                    }
                }
        );
    }
}
