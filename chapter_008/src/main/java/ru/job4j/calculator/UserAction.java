package ru.job4j.calculator;

/**
 * interface UserAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public interface UserAction {

    void execute(Input input, Calculator calculator);

    String getKey();

    String info();
}
