package ru.job4j.tracker;

/**
 *класс StartUI
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.2
 * @since 14.12.2018
 */

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if(value == key) {
                exist = true;
                break;
            }
        }
        if(exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}