package ru.job4j.design.productStore;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        double quality = food.convertQualityToPercent(food.getCreateDate(), food.getExpirationDate());
        return quality >= 100;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getFood() {
        return foods;
    }
}
