package ru.job4j.gc.jmh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * class Article.
 *
 * @author Vladimir Seregin
 * @version 1.0
 */
public class Article {

    /**
     * This method checks that the new text was derived from the original.
     * @param origin - The original text.
     * @param line - The new text.
     * @return true if the new text was obtained from the original, otherwise false.
     */
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        Set<String> originSet = new HashSet<>(
                Arrays.asList(origin.replaceAll("[.,;:!?]", "").split(" "))
        );
        for (String word : line.split(" ")) {
            if (!originSet.contains(word)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
