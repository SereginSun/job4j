package ru.job4j.design.product;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStore implements Store {
    private List<Food> foods = new ArrayList<>();
}
