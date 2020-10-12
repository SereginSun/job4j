package ru.job4j.design.tictactoe;

import java.util.List;

/**
 * interface Input.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface Input {

    /**
     * The method returns data entered in the console after the asked question.
     * @param question, which is displayed to the user.
     * @return a string with user input.
     */
    String askStr(String question);

    /**
     * The method returns data entered in the console after the asked question.
     * @param questions, which is displayed to the user.
     * @param range - range of possible options.
     * @return an integer key if it matches a value from the list of possible options.
     */
    int askInt(String questions, List<Integer> range);
}
