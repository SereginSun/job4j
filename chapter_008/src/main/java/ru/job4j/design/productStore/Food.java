package ru.job4j.design.productStore;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Food {
    private String Name;
    private LocalDate expirationDate;
    private LocalDate createDate;
    private Double price;
    private Double discount;

    public Food(String name, LocalDate expirationDate, LocalDate createDate, Double price) {
        Name = name;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(Name, food.Name) &&
                Objects.equals(expirationDate, food.expirationDate) &&
                Objects.equals(createDate, food.createDate) &&
                Objects.equals(price, food.price) &&
                Objects.equals(discount, food.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, expirationDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{" +
                "Name='" + Name + '\'' +
                ", expirationDate=" + expirationDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
