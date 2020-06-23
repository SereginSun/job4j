package ru.job4j.design.productStore;

import java.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate expirationDate, LocalDate createDate, Double price) {
        super(name, expirationDate, createDate, price);
    }
}
