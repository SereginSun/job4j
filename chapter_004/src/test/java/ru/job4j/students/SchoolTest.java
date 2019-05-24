package ru.job4j.students;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 22.04.2019
 */
public class SchoolTest {

    @Test
    public void whenScoreMoreBoundReturnSortedListOfStudent() {
            School secondarySchool = new School();
            List<Student> students = Arrays.asList(
                    new Student("Bezborodov", 85),
                    null,
                    new Student("Abramovich", 52),
                    new Student("Yablokov", 38),
                    null,
                    new Student("Pozharsky", 70),
                    null,
                    new Student("Toropcev", 95)
            );
            List<Student> expected = List.of(
                    new Student("Toropcev", 95),
                    new Student("Bezborodov", 85)
            );
            assertThat(secondarySchool.levelOf(students, 80), is(expected));
    }
}