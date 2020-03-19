package ru.job4j.calculator;

import java.util.InputMismatchException;

/**
 * class ValidateInput - verification of data entered by the user in the console.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class ValidateInput extends ConsoleInput {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public Double askNum(String question) {
        boolean invalid = true;
        Double value = 0.0;
        do {
            try {
                value = this.input.askNum(question);
                invalid = false;
            } catch (InputMismatchException ime) {
                System.out.println("Input must be a number.");
            }
        } while (invalid);
        return value;
    }
}
