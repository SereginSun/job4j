package ru.job4j.design.tictactoe;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    private static final String LN = System.getProperty("line.separator");

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(mem);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    private final String menu1 = Joiner.on(LN).join(
            "-=0   Exit",
            "-=1   3x3",
            "-=2   5x5"
    );

    private final String menu2 = Joiner.on(LN).join(
            "-=0   Exit",
            "-=1   User starts first.",
            "-=2   Computer starts first."
    );

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInputInFirstMenu() {
        Input in = new ValidateInput(new StubInput(new String[]{"Invalid", "0"}));
        Game game = new Game();
        StartUI start = new StartUI(in, output);
        start.start(game);
        assertThat(new String(this.mem.toByteArray()), is(
                Joiner.on(LN).join(
                        menu1,
                        "Enter the INTEGER number again!",
                        ""
                )
        ));
    }

    @Test
    public void whenInvalidInputInSecondMenu() {
        Input in = new ValidateInput(new StubInput(new String[]{"1", "Invalid", "0"}));
        Game game = new Game();
        StartUI start = new StartUI(in, output);
        start.start(game);
        assertThat(new String(this.mem.toByteArray()), is(
                Joiner.on(LN).join(
                        menu1,
                        "Building field 3х3.",
                        menu2,
                        "Enter the INTEGER number again!",
                        ""
                )
        ));
    }
}