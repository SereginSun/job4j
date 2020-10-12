package ru.job4j.design.tictactoe;

import java.util.function.Consumer;

/**
 * class StartUI.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class StartUI {
    private final Input input;
    private final Consumer<String> output;

    public StartUI(Input input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    public void start(Game game) {
        Menu firstMenu = new Menu(input, output, game);
        firstMenu.fillFirstMenu();
        Menu secondMenu = new Menu(input, output, game);
        secondMenu.fillSecondMenu();
        while (!firstMenu.isExit && !secondMenu.isExit) {
            firstMenu.run();
            if (firstMenu.isExit) {
                break;
            }
            secondMenu.run();
            if (secondMenu.isExit) {
                break;
            }
            game.init(input, output);
            firstMenu.returnGame();
        }
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI(new ValidateInput(new ConsoleInput()), System.out::println);
        startUI.start(new Game());
    }
}
