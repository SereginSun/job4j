package ru.job4j.design.productStore;

import java.time.LocalDate;

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
