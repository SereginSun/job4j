package ru.job4j.design.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * class Menu.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class Menu implements IMenu {
    private final Input input;
    private final Consumer<String> output;
    private final List<MenuEntry> entries = new ArrayList<>();
    private final Game game;
    protected boolean isExit;

    public Menu(Input input, Consumer<String> output, Game game) {
        this.input = input;
        this.output = output;
        this.game = game;

        entries.add(new MenuEntry(0, "Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    @Override
    public void run() {
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            range.add(i);
        }
        show();
        int choice = input.askInt("Select menu item: ", range);
        MenuEntry entry = entries.get(choice);
        entry.run();
    }

    @Override
    public void show() {
        for (MenuEntry entry : entries) {
            if (entry != null) {
                System.out.println(entry);
            }
        }
    }

    public void returnGame() {
        String answer = input.askStr("Next game? (y/n)\n");
        if (answer.equals("n")) {
            isExit = true;
        }
    }

    public void fillFirstMenu() {

        entries.add(new MenuEntry(1, "3x3") {
            @Override
            public void run() {
                output.accept("Building field 3х3.");
            }
        });
        entries.add(new MenuEntry(2, "5x5") {
            @Override
            public void run() {
                output.accept("Building field  5x5.");
                game.switchSize();
            }
        });
    }

    public void fillSecondMenu() {
        entries.add(new MenuEntry(1, "User starts first.") {
            @Override
            public void run() {
                output.accept("User will go first.");
            }
        });
        entries.add(new MenuEntry(2, "Computer starts first.") {
            @Override
            public void run() {
                output.accept("The computer will go first.");
                game.switchPriority();
            }
        });
    }
}
