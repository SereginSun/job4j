package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayHasDuplicatesThenDropIt() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.removeDuplicate(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
    @Test
    public void whenIntArrayHasDuplicatesThenDropIt() {
        String[] input = {"Три", "Пять", "Девять", "Один", "Пять"};
        String[] expect = {"Три", "Пять", "Девять", "Один"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.removeDuplicate(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}