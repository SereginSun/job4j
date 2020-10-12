package ru.job4j.design.tictactoe;

import java.util.function.Consumer;

/**
 * class Computer implements IPlayer the interface and describes the behavior of the player computer.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class Computer implements IPlayer {
    private final IBoard grid;
    private final CellValue sign;
    private final CPULogic turn;
    private final Consumer<String> output;

    public Computer(CPULogic turn, Consumer<String> output) {
        this.grid = turn.getGrid();
        this.sign = CellValue.CPU;
        this.turn = turn;
        this.output = output;
    }

    @Override
    public void makeTurn() {
        output.accept("Ходит CPU");
        int number = turn.getCellNumb();
        grid.makeTurn(number, sign);
    }

    @Override
    public CellValue getSign() {
        return this.sign;
    }
}
