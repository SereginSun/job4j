package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private List<Student> students = Arrays.asList(
            new Student("Bezborodov", 85),
            new Student("Abramovich", 52),
            new Student("Yablokov", 38),
            new Student("Pozharsky", 70)
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

    @Test
    public void whenStudentsListConvertToMap() {
        Map<String, Student> result = new School().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Bezborodov", new Student("Bezborodov", 85));
        expected.put("Abramovich", new Student("Abramovich", 52));
        expected.put("Yablokov", new Student("Yablokov", 38));
        expected.put("Pozharsky", new Student("Pozharsky", 70));
        assertThat(result, is(expected));
    }
}