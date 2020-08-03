package ru.job4j.design.product;

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
                LocalDate.now().plusDays(34),
                LocalDate.now().minusDays(5),
                100.10
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse, shope, trash));
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
                LocalDate.now().plusDays(9),
                LocalDate.now().minusDays(5),
                84.20
        );
        Food beef = new Fruit(
                "beef",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(4),
                230.40
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse, shope, trash));
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
                LocalDate.of(2020, Month.JUNE, 10),
                84.20
        );
        Food beef = new Meat(
                "beef",
                LocalDate.of(2020, Month.JUNE, 24),
                LocalDate.of(2020, Month.JUNE, 19),
                230.40
        );
        Food milk = new Milk(
                "yogurt",
                LocalDate.of(2020, Month.JUNE, 25),
                LocalDate.of(2020, Month.JUNE, 11),
                52.00
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));
        cq.addFood(List.of(bananas, beef, milk));
        assertThat(trash.getFood(), is(List.of(bananas, beef, milk)));
    }

    @Test
    public void whenFoodResort() {
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        Store shop = new Shop();
        Food bananas = new Fruit(
                "bananas",
                LocalDate.of(2020, Month.JUNE, 24),
                LocalDate.of(2020, Month.JUNE, 10),
                84.20
        );
        Food beef = new Meat(
                "beef",
                LocalDate.of(2020, Month.JUNE, 24),
                LocalDate.of(2020, Month.JUNE, 19),
                230.40
        );
        Food milk = new Milk(
                "yogurt",
                LocalDate.of(2020, Month.JUNE, 25),
                LocalDate.of(2020, Month.JUNE, 11),
                52.00
        );
        ControlQuality cq = new ControlQuality(List.of(warehouse, shop, trash));
        cq.addFood(List.of(bananas, beef, milk));
        cq.resort();
        assertThat(trash.getFood(), is(List.of(bananas, beef, milk)));
    }
}