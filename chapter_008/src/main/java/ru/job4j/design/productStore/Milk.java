package ru.job4j.design.productStore;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, LocalDate expirationDate, LocalDate createDate, Double price) {
        super(name, expirationDate, createDate, price);
    }
}
