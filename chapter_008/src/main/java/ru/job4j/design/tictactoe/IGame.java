package ru.job4j.design.tictactoe;

import java.util.function.Consumer;

/**
 * interface IGame.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface IGame {

    /**
     * The method of initializing the components of the gameplay.
     * @param input - input data.
     * @param output - output.
     */
    void init(Input input, Consumer<String> output);

    /**
     * The method switches the order of the players' turn.
     */
    void switchPriority();

    /**
     * The method changes the size of the playing field.
     */
    void switchSize();
}
