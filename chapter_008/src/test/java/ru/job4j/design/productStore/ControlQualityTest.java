package ru.job4j.design.productStore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenFoodMoveToWarehouse() {
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        Store shope = new Shop();
        Food orange = new Fruit(
                "orange",
                LocalDate.of(2020, Month.JULY, 30),
                LocalDate.of(2020, Month.JUNE,20),
                100.10
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse,shope, trash));
        cq.addFood(List.of(orange));
        assertThat(warehouse.getFood(), is(List.of(orange)));
    }

    @Test
    public void whenFoodMoveToShop() {
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        Store shope = new Shop();
        Food bananas = new Fruit(
                "bananas",
                LocalDate.of(2020, Month.JULY, 1),
                LocalDate.of(2020, Month.JUNE,17),
                84.20
        );
        Food beef = new Fruit(
                "beef",
                LocalDate.of(2020, Month.JUNE, 26),
                LocalDate.of(2020, Month.JUNE,21),
                230.40
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse,shope, trash));
        cq.addFood(List.of(bananas, beef));
        assertThat(shope.getFood(), is(List.of(bananas, beef)));
        assertThat(beef.getDiscount(), is(15.0));
    }

    @Test
    public void whenFoodMoveToTrash() {
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        Store shop = new Shop();
        Food bananas = new Fruit(
                "bananas",
                LocalDate.of(2020, Month.JUNE, 24),
                LocalDate.of(2020, Month.JUNE,10),
                84.20
        );
        Food beef = new Meat(
                "beef",
                LocalDate.of(2020, Month.JUNE, 24),
                LocalDate.of(2020, Month.JUNE,19),
                230.40
        );
        Food milk = new Milk(
                "yogurt",
                LocalDate.of(2020, Month.JUNE, 25),
                LocalDate.of(2020, Month.JUNE,11),
                52.00
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));
        cq.addFood(List.of(bananas, beef, milk));
        assertThat(trash.getFood(), is(List.of(bananas, beef, milk)));
    }
}