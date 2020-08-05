package ru.job4j.design.product;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality implements Control {

    private final List<Store> storages;

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public void addFood(List<Food> foods) {
        for (Food food : foods) {
            for (Store storage : storages) {
                if (storage.accept(food)) {
                    storage.add(food);
                    break;
                }
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : storages) {
            foods.addAll(store.getFood());
            store.extractAll();
        }
        addFood(foods);
    }
}
