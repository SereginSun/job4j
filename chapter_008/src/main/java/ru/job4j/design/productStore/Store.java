package ru.job4j.design.productStore;

import java.util.List;

public interface Store {

    boolean accept(Food food);

    void add(Food food);

    List<Food> getFood();
}
