package ru.job4j.design.product;

public class Trash extends BaseStore {

    @Override
    public boolean accept(Food food) {
        double quality = food.convertQualityToPercent(food.getCreateDate(), food.getExpirationDate());
        return quality >= 100;
    }
}
