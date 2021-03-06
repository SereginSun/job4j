package ru.job4j.design.product;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStore implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public List<Food> getFood() {
        return foods;
    }

    @Override
    public void extractAll() {
        foods.clear();
    }
}
