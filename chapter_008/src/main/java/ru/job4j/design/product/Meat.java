package ru.job4j.design.product;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate expirationDate, LocalDate createDate, Double price) {
        super(name, expirationDate, createDate, price);
    }
}
