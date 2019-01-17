package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * например, если пользователь
     * хочет выбрать добавление новой заявки, ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выход из трекера
     */
     private final String[] value;

     /**
     * поле считает количество вызовов метода ask
     * при каждом вызове нужно передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * У нас есть объект, в котором содержаться заранее продуманные ответы.
     * При последовательном вызове метода ask, нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счётчик и
     * при следующем вызове он вернёт нам новое замечание.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, List<Integer> range) {
        return Integer.valueOf(this.value[this.position++]);
    }
}
