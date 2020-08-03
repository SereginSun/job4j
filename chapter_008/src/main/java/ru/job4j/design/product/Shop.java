package ru.job4j.design.product;

public class Shop extends BaseStore {

    @Override
    public boolean accept(Food food) {
        double quality = food.convertQualityToPercent(food.getCreateDate(), food.getExpirationDate());
        if (quality >= 75) {
            food.setDiscount(15.0);
        }
        return quality >= 25 && quality < 100;
    }
}
