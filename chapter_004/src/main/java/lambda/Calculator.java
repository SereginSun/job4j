package lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {

    /**
     * This interface describes a function that takes two parameters left, right
     * and returns a value of type double.
     */
    public interface Operation {
        double calc(int left, int right);
    }

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(0, 10, 2,
                MathUtil::add,
                result -> System.out.println(result)
        );
    }
}
