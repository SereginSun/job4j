package ru.job4j.design.tdd.generator;

import java.util.Map;

public class SimpleGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        return "I am Petr Arsentev, Who are you?";
    }
}
