package ru.job4j.design.productStore;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public boolean accept(Food food) {

        return false;
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
