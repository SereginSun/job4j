package ru.job4j.design.product;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        double quality = food.convertQualityToPercent(food.getCreateDate(), food.getExpirationDate());
        if (quality >= 75) {
            food.setDiscount(15.0);
        }
        return quality >= 25 && quality < 100;
    }

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> getFood() {
        return foodList;
    }
}
