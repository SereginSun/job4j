package ru.job4j.calculator.arithmetic;

import ru.job4j.calculator.BaseAction;
import ru.job4j.calculator.Calculator;
import ru.job4j.calculator.Input;

import java.util.function.Consumer;

/**
 * class AddAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class AddAction extends BaseAction {

    private final Consumer<String> output;

    public AddAction(final String key, final String name, final Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Calculator calculator) {
        double first = input.askNum("The first number: ");
        double second = input.askNum("The second number: ");
        calculator.add(first, second);
        output.accept("Result: ".concat(String.valueOf(calculator.getResult())));
    }
}
