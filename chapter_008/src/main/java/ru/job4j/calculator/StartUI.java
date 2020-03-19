package ru.job4j.calculator;

import java.util.function.Consumer;

/**
 * class StartUI.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class StartUI {

    private final Input input;
    private final Calculator calculator;
    private final Consumer<String> output;

    public StartUI(final Input input, final Calculator calculator, final Consumer<String> output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    /**
     * The main cycle of the program.
     */
    public void init() {
        MenuCalc menu = new MenuCalc(this.input, this.calculator, this.output);
        menu.fillActions();
        do {
            menu.showMenu();
            try {
                menu.select(input.askStr("Enter action"));
            } catch (MenuOutException meo) {
                output.accept("The entered character does not correspond to the menu!");
            }
        } while (!"yes".equals(this.input.askStr("Exit? (yes): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Calculator(), System.out::println).init();
    }
}
