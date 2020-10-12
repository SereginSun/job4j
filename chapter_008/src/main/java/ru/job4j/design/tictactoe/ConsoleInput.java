package ru.job4j.design.tictactoe;

import java.util.List;
import java.util.Scanner;

/**
 * class ConsoleInput.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * The method returns data entered in the console after the asked question.
     * @param question, which is displayed to the user.
     * @return a string with user input.
     */
    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * The method returns data entered in the console after the asked question.
     * @param questions, which is displayed to the user.
     * @param range - range of possible options.
     * @return an integer key if it matches a value from the list of possible options.
     */
    @Override
    public int askInt(String questions, List<Integer> range) {
        int key = Integer.parseInt(askStr(questions));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new RangeOutException("Out of board range.");
        }
        return key;
    }
}
