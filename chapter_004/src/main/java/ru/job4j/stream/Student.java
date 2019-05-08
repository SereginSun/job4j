package ru.job4j.stream;

import java.util.Objects;

/**
 * class Student
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 02.05.2019
 */
public class Student {

    private String lastName;
    private int score;

    public Student(String lastName, int score) {
        this.lastName = lastName;
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, score);
    }
}
