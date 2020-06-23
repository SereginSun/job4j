package ru.job4j.design.productStore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenFoodMoveToWarehouse() {
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        Store shope = new Shop();
        Food orange = new Fruit("orange", LocalDate.of(2020, Month.JUNE,1), LocalDate.of(2020, Month.JUNE, 30), 100.10);
        ControlQuality cq = new ControlQuality();
    }

}