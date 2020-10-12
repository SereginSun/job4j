package ru.job4j.design.tictactoe;

import java.util.function.Consumer;

/**
 * class Logic implements ILogic the interface describes the rules of the Tic-Tac-Toe game.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class Logic implements ILogic {
    private final IBoard grid;
    private final Consumer<String> output;

    public Logic(IBoard gameTable, Consumer<String> output) {
        this.grid = gameTable;
        this.output = output;
    }

    @Override
    public boolean handleTurn(CellValue figure) {
        if (getWinner(figure)) {
            output.accept(figure + " is WIN!\n");
            return false;
        }
        if (isDraw()) {
            output.accept("It is Draw!\n");
            return false;
        }
        return true;
    }

    @Override
    public boolean getWinner(CellValue figure) {
        return findWinnerByRow(figure)
                || findWinnerByColumn(figure)
                || findWinnerByMainDiagonal(figure)
                || findWinnerByNotMainDiagonal(figure);
    }

    @Override
    public boolean findWinnerByRow(CellValue figure) {
        for (int i = 0; i < grid.getSize(); i++) {
            int count = 0;
            for (int k = 0; k < grid.getSize(); k++) {
                if (grid.getValue(i, k) == figure) {
                    count++;
                }
            }
            if (count == grid.getSize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findWinnerByColumn(CellValue figure) {
        for (int i = 0; i < grid.getSize(); i++) {
            int count = 0;
            for (int k = 0; k < grid.getSize(); k++) {
                if (grid.getValue(k, i) == figure) {
                    count++;
                }
            }
            if (count == grid.getSize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findWinnerByMainDiagonal(CellValue figure) {
        int count = 0;
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(i, i) == figure) {
                count++;
            }
            if (count == grid.getSize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findWinnerByNotMainDiagonal(CellValue figure) {
        int count = 0;
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(grid.getSize() - i - 1, i) == figure) {
                count++;
            }
            if (count == grid.getSize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDraw() {
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                if (grid.getValue(i, j) == CellValue.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
