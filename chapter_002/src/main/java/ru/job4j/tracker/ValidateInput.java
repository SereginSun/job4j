package ru.job4j.tracker;

import java.util.List;

/**
 * ValidateInput - проверка данных, введёных пользователем в консоли.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *  * @version 1.0.1
 *  * @since 15.01.2019
 */

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите номер позиции.");
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста, введите номер позиции из меню.");
            }
        } while (invalid);
        return value;
    }
}
