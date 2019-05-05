package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private List<Student> students = Arrays.asList(
            new Student(85),
            new Student(52),
            new Student(38),
            new Student(70)
    );

    @Test
    public void whenStudentDistributeToClassA() {
        List<Student> result = new School().collect(students, student -> student.getScore() >= 70);
        assertThat(result, is(Arrays.asList(students.get(0), students.get(3))));
    }

    @Test
    public void whenStudentDistributeToClassB() {
        List<Student> result = new School().collect(
                students, student -> student.getScore() >= 50 && student.getScore() < 70
        );
        assertThat(result, is(Arrays.asList(students.get(1))));
    }

    @Test
    public void whenStudentDistributeToClassC() {
        List<Student> result = new School().collect(students, student -> student.getScore() < 50);
        assertThat(result, is(Arrays.asList(students.get(2))));
    }
}