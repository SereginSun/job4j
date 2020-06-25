package ru.job4j.design.product;

import java.util.List;

public class ControlQuality {

    private List<Store> storages;

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
}
