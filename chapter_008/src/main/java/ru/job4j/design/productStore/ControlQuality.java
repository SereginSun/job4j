package ru.job4j.design.productStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {

    private List<Store> storages;

    public ControlQuality() {
        this.storages = new ArrayList<>();
    }

    public void checkFood(List<Food> foods) {

    }

    public double convertQualityToPercent(LocalDate createDate, LocalDate expirationDate) {
        LocalDate today = LocalDate.now();
        long allDays = DAYS.between(createDate, expirationDate);
        long remainingDays = DAYS.between(createDate, today);
        return (double) remainingDays / allDays * 100;
    }

    public void addFood(Food food, int discount) {
        double quality = this.convertQualityToPercent(food.getCreateDate(), food.getExpirationDate());

    }


}
