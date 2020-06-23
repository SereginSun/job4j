package ru.job4j.design.productStore;

import java.util.List;

public class Trash implements Store {

    @Override
    public boolean accept(Food food) {

        return false;
    }

    @Override
    public void add(Food food) {

    }

    @Override
    public List<Food> getFood() {
        return null;
    }
}
