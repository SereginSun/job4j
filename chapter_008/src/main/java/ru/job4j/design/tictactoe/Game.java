package ru.job4j.design.tictactoe;

import java.util.function.Consumer;

/**
 * class Game.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class Game implements IGame {
    private static final int DEFAULT_SIZE = 3;

    private boolean firstUser;
    private int gridSize;

    public Game() {
        this.firstUser = true;
        this.gridSize = DEFAULT_SIZE;
    }

    @Override
    public void init(Input input, Consumer<String> output) {
        IBoard grid = new GameIBoard(gridSize);
        IDisplay IDisplay = new PrintGrid(grid);
        grid.fillGameTable();
        IDisplay.printGameTable();
        IPlayer user = new Human(grid, input);
        CPULogic logicBot = new CPULogic(grid);
        IPlayer bot = new Computer(logicBot, output);
        IPlayer[] priority = firstUser ? new IPlayer[]{user, bot} : new IPlayer[]{bot, user};
        output.accept("A new game started");
        Logic logic = new Logic(grid, output);
        boolean isWin = true;
        while (isWin) {
            for (IPlayer IPlayer : priority) {
                IPlayer.makeTurn();
                IDisplay.printGameTable();
                if (!logic.handleTurn(IPlayer.getSign())) {
                    isWin = false;
                    break;
                }
            }
        }
    }

    @Override
    public void switchPriority() {
        this.firstUser = false;
    }

    @Override
    public void switchSize() {
        gridSize = 5;
    }
}
