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

    /**
     * Selection of students for their score, excluding null entries in the List.
     *
     * @param students - List of students.
     * @param bound - minimum score level.
     * @return List of students who have a score higher than the boundary value.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
            return students.stream()
                    .sorted(Comparator.nullsLast(Comparator.comparing(Student::getScore).reversed()))
                    .flatMap(Stream::ofNullable)
                    .takeWhile(student -> student.getScore() > bound)
                    .collect(Collectors.toList());
    }
}
