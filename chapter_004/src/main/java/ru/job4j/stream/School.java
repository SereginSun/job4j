package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * class School
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 02.05.2019
 */
public class School {

    /**
     * This method distributes pupils into classes according to academic achievement.
     * @param student - List of student.
     * @param predicate - Predicate (Student's score)
     * @return Students that fit on predicate.
     */
    List<Student> collect(List<Student> student, Predicate<Student> predicate) {
        return student.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * This method convert students List to Map.
     *
     * @param students - List of students.
     * @return Map of students.
     */
    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getLastName, student -> student));
    }
}
