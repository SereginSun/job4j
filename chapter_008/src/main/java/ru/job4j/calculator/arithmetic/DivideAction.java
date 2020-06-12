package ru.job4j.calculator.arithmetic;

import ru.job4j.calculator.Calculator;
import ru.job4j.calculator.Input;
import ru.job4j.calculator.BaseAction;

import java.util.function.Consumer;

/**
 * class DivideAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class DivideAction extends BaseAction {

    private final Consumer<String> output;

    public DivideAction(final String key, final String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Calculator calculator) {
        double first = input.askNum("The first number: ");
        double second = input.askNum("The second number: ");
        calculator.div(first, second);
        output.accept("Result: ".concat(String.valueOf(calculator.getResult())));
    }
}
