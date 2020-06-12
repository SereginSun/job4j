package ru.job4j.calculator.arithmetic;

import ru.job4j.calculator.Calculator;
import ru.job4j.calculator.Input;
import ru.job4j.calculator.BaseAction;

import java.util.function.Consumer;

/**
 * class MultiplyAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class MultiplyAction extends BaseAction {

    private final Consumer<String> output;

    public MultiplyAction(final String key, final String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Calculator calculator) {
        double first = input.askNum("Первое число: ");
        double second = input.askNum("Второе число: ");
        calculator.multiple(first, second);
        output.accept("Result: ".concat(String.valueOf(calculator.getResult())));
    }
}
