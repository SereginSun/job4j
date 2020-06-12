package ru.job4j.calculator;

/**
 * class StubInput that contains the sequence of user responses.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String askStr(String question) {
        return this.value[position++];
    }

    @Override
    public Double askNum(String question) {
        return Double.valueOf(this.value[position++]);
    }
}
