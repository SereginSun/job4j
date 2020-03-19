package ru.job4j.calculator;

import ru.job4j.calculator.arithmetic.DivideAction;
import ru.job4j.calculator.arithmetic.MultiplyAction;
import ru.job4j.calculator.arithmetic.SubtractAction;
import ru.job4j.calculator.arithmetic.AddAction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * class MenuCalc.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class MenuCalc {

    private Input input;
    private Calculator calculator;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    public MenuCalc(Input input, Calculator calculator, final Consumer<String> output) {
        this.input = input;
        this.calculator = calculator;
        this.output = output;
    }

    /**
     * The method fills the menu.
     */
    public void fillActions() {
        this.actions.add(new AddAction("+", "Addition", output));
        this.actions.add(new SubtractAction("-", "Subtraction", output));
        this.actions.add(new DivideAction("/", "Division", output));
        this.actions.add(new MultiplyAction("*", "Multiplication", output));
    }

    /**
     * The method, depending on the specified key, performs the corresponding action.
     * @param key - operation key.
     */
    public void select(String key) {
        for (UserAction action : actions) {
            if (action.getKey().contains(key) && !key.equals("")) {
                action.execute(this.input, this.calculator);
            }
        }
    }

    /**
     * The method displays the menu.
     */
    public void showMenu() {
        for (UserAction action : actions) {
            output.accept(action.info());
        }
    }
}
