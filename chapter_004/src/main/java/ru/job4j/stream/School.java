package ru.job4j.stream;

import java.util.List;
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
}
