package ru.job4j.design.product;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Food {
    private String name;
    private LocalDate expirationDate;
    private LocalDate createDate;
    private Double price;
    private Double discount;

    public Food(String name, LocalDate expirationDate, LocalDate createDate, Double price) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public double convertQualityToPercent(LocalDate createDate, LocalDate expirationDate) {
        LocalDate today = LocalDate.now();
        long allDays = DAYS.between(createDate, expirationDate);
        long remainingDays = DAYS.between(createDate, today);
        return (double) remainingDays / allDays * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(expirationDate, food.expirationDate)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(price, food.price)
                && Objects.equals(discount, food.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expirationDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{"
                + "Name='" + name + '\''
                + ", expirationDate=" + expirationDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
