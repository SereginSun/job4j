package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class DepartmentTest
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.04.2019
 */
public class DepartmentTest {
    private final Department depSort = new Department();
    private final List<String> listDepartment = new ArrayList<>();

    @Before
    public void inputList() {
        listDepartment.add("K2\\SK1\\SSK1");
        listDepartment.add("K1");
        listDepartment.add("K1\\SK1\\SSK1");
        listDepartment.add("K1\\SK2");
        listDepartment.add("K2");
        listDepartment.add("K1\\SK1");
        listDepartment.add("K2\\SK1\\SSK2");
    }

    @Test
    public void whenAscendingSort() {
        depSort.ascendingSort(listDepartment);
        List<String> expected = new ArrayList<>();
        expected.add("K1");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK1");
        expected.add("K1\\SK2");
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K2\\SK1\\SSK2");
        assertThat(listDepartment, is(expected));
    }

    @Test
    public void whenDescendingSort() {
        depSort.descendingSort(listDepartment);
        List<String> expected = new ArrayList<>();
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK2");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K1");
        expected.add("K1\\SK2");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK1");
        assertThat(listDepartment, is(expected));
    }
}