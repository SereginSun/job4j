package ru.job4j.design.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class CPULogic implements ICPULogic the interface describes the logic of the player's computer's turn.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class CPULogic implements ICPULogic {
    private final IBoard grid;
    private int cellsNumb;

    public CPULogic(IBoard grid) {
        this.grid = grid;
    }

    @Override
    public IBoard getGrid() {
        return this.grid;
    }

    @Override
    public int getCellNumb() {
        if (tryWin(CellValue.CPU) || tryWin(CellValue.HUMAN)) {
            return cellsNumb;
        } else {
            return makeRandomComputerTurn();
        }
    }

    @Override
    public boolean tryWin(CellValue figure) {
        return trySetToRow(figure)
                || trySetToColumn(figure)
                || trySetToMainDiagonal(figure)
                || trySetToNotMainDiagonal(figure);
    }

    @Override
    public boolean trySetToRow(CellValue figure) {
        boolean result = false;
        int numb = -1;
        for (int i = 0; i < grid.getSize(); i++) {
            int count = 0;
            for (int k = 0; k < grid.getSize(); k++) {
                if (grid.getValue(i, k) == figure) {
                    count++;
                } else if (grid.getValue(i, k) == CellValue.EMPTY) {
                    numb = grid.getCellsNumb(i, k);
                }
            }
            if (count == grid.getSize() - 1 && numb != -1) {
                result = true;
                cellsNumb = numb;
            }
        }
        return result;
    }

    @Override
    public boolean trySetToColumn(CellValue figure) {
        boolean result = false;
        int numb = -1;
        for (int i = 0; i < grid.getSize(); i++) {
            int count = 0;
            for (int k = 0; k < grid.getSize(); k++) {
                if (grid.getValue(k, i) == figure) {
                    count++;
                } else if (grid.getValue(k, i) == CellValue.EMPTY) {
                    numb = grid.getCellsNumb(k, i);
                }
            }
            if (count == grid.getSize() - 1 && numb != -1) {
                result = true;
                cellsNumb = numb;
            }
        }
        return result;
    }

    @Override
    public boolean trySetToMainDiagonal(CellValue figure) {
        boolean result = false;
        int count = 0;
        int numb = -1;
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(i, i) == figure) {
                count++;
            } else if (grid.getValue(i, i) == CellValue.EMPTY) {
                numb = grid.getCellsNumb(i, i);
            }
            if (count == grid.getSize() - 1 && numb != -1) {
                result = true;
                cellsNumb = numb;
            }
        }
        return result;
    }

    @Override
    public boolean trySetToNotMainDiagonal(CellValue figure) {
        boolean result = false;
        int count = 0;
        int numb = -1;
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.getValue(grid.getSize() - i - 1, i) == figure) {
                count++;
            }  else if (grid.getValue(grid.getSize() - i - 1, i) == CellValue.EMPTY) {
                numb = grid.getCellsNumb(grid.getSize() - i - 1, i);
            }
            if (count == grid.getSize() - 1 && numb != -1) {
                result = true;
                cellsNumb = numb;
            }
        }
        return result;
    }

    @Override
    public int makeRandomComputerTurn() {
        List<Cell> emptyCell = new ArrayList<>();
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                if (grid.getValue(i, j) == CellValue.EMPTY) {
                    emptyCell.add(new Cell(i, j));
                }
            }
        }
        Cell randomCell = emptyCell.get(new Random().nextInt(emptyCell.size()));
        return grid.getCellsNumb(randomCell.getRowIndex(), randomCell.getColIndex());
    }
}
