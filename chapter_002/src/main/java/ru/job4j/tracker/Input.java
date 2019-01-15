package ru.job4j.tracker;

import java.util.List;

/**
 *класс StartUI
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 14.12.2018
 */
public interface Input {
    String ask(String question);

    int ask(String question, List<Integer> range);
}
