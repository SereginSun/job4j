package ru.job4j.design.tdd.generator;

import java.util.Map;

/**
 * class SimpleGenerator.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.08.2020
 */
public class SimpleGenerator implements Generator {

    @Override
    public String produce(String template, Map<String, String> args) {
        return "I am Petr Arsentev, Who are you?";
    }
}
