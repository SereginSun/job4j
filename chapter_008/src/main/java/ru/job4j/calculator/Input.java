package ru.job4j.calculator;

/**
 * interface Input.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public interface Input {

    String askStr(String question);

    Double askNum(String question);
}
