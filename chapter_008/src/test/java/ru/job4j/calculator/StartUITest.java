package ru.job4j.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ValidateInput - verification of data entered by the user in the console.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 19.03.2020
 */
public class StartUITest {

    private static final String LN = System.lineSeparator();

    private final String menu = new StringBuilder()
            .append("\"+\" - Addition")
            .append(LN)
            .append("\"-\" - Subtraction")
            .append(LN)
            .append("\"/\" - Division")
            .append(LN)
            .append("\"*\" - Multiplication")
            .append(LN)
            .toString();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {

        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(System.out);
    }

    @Test
    public void whenFrom5Subtract3ThenResultIs2() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"-", "5", "3", "yes"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
        assertThat(out.toString(), is(menu + "Result: 2.0" + LN));
    }

    @Test
    public void when11Multiply12ThenResultIs132() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"*", "11", "12", "yes"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
        assertThat(out.toString(), is(menu + "Result: 132.0" + LN));
    }

    @Test
    public void whenToAddDoubleNumbersThenResultIs() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"+", "12.5", "38.3", "yes"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
        assertThat(out.toString(), is(menu + "Result: 50.8" + LN));
    }

    @Test
    public void when4Dot4DivideBy2ThenResultIs2Dot2() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"/", "4.4", "2", "yes"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
        assertThat(out.toString(), is(menu + "Result: 2.2" + LN));
    }

    @Test
    public void whenInputOutOfMenu() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"?", "yes"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
        assertThat(out.toString(), is(menu));
    }

    @Test (expected = NumberFormatException.class)
    public void whenInputNoNumber() {
        Calculator calc = new Calculator();
        Input input = new StubInput(new String[] {"-", "!"});
        StartUI run = new StartUI(input, calc, output);
        run.init();
    }
}