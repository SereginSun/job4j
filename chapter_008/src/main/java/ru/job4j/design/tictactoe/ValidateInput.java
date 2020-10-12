package ru.job4j.design.tictactoe;

import java.util.List;

/**
 * class ValidateInput - handles invalid user input.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return this.input.askStr(question);
    }

    @Override
    public int askInt(String questions, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.askInt(questions, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Enter the INTEGER number again!");
            } catch (RangeOutException roe) {
                System.out.print("Select empty cell number: ");
                for (var in : range) {
                    System.out.printf(" %s ", in);
                }
                System.out.println();
            }
        } while (invalid);
        return value;
    }
}
