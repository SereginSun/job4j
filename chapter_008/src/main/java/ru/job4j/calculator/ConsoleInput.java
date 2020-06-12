package ru.job4j.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class ConsoleInput BaseAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

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
     * If the input type does not match the Double type, an exception is thrown InputMismatchException.
     * @param question, which is displayed to the user.
     * @return a number of double of type with user input.
     */
    @Override
    public Double askNum(String question) {
        String textValue = askStr(question);
        if (textValue.matches("-?\\d+(\\.\\d+)?")) {
            return Double.valueOf(textValue);
        } else {
            throw new InputMismatchException();
        }
    }
}
