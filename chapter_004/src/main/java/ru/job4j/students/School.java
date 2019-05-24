package ru.job4j.students;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class School, implements sorted of students by score
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 22.04.2019
 */
public class School {

    private final Comparator<Student> comp = (o1, o2) -> {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null || o2 == null) {
            return o1 == null ? 1 : -1;
        }
        return Integer.compare(o2.getScore(), o1.getScore());
    };

    /**
     * Selection of students for their score, excluding null entries in the List.
     *
     * @param students - List of students.
     * @param bound - minimum score level.
     * @return List of students who have a score higher than the boundary value.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
            return students.stream()
                    .sorted(comp)
                    .flatMap(Stream::ofNullable)
                    .takeWhile(student -> student.getScore() > bound)
                    .collect(Collectors.toList());
    }
}
