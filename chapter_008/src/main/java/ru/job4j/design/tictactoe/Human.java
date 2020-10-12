package ru.job4j.design.tictactoe;

/**
 * class Human implements IPlayer the interface and describes the behavior of the human player.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class Human implements IPlayer {
    private final IBoard grid;
    private final CellValue sign;
    private final Input input;

    public Human(IBoard grid, Input input) {
        this.grid = grid;
        this.sign = CellValue.HUMAN;
        this.input = input;
    }

    @Override
    public void makeTurn() {
        int number = input.askInt("Please type number: ", grid.getListEmptyCells());
        grid.makeTurn(number, sign);
    }

    @Override
    public CellValue getSign() {
        return this.sign;
    }
}
