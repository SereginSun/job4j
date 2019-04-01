package ru.job4j.comparator;

import java.util.Comparator;

/**
 * class ListCompare
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 02.04.2019
 */
public class ListCompare implements Comparator<String> {

    /**
     * The method implements its own variant the method compare for comparing two Strings.
     * @param left the first string.
     * @param right the second string.
     * @return 0 - when strings equals; 1 - when the first string is lexicographically greater;
     * -1 - when the second string is lexicographically greater.
     */
    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < minLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result !=0 || left.length() == right.length() ? result : Integer.compare(left.length(), right.length());
    }
}
