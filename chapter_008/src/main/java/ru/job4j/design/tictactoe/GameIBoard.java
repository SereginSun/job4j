package ru.job4j.design.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * class GameIBoard implements IBoard the interface describes the playing field.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class GameIBoard implements IBoard {
    private final int size;
    private final CellValue[][] grid;

    public GameIBoard(int size) {
        this.size = size;
        this.grid = new CellValue[size][size];
    }

    @Override
    public void fillGameTable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = CellValue.EMPTY;
            }
        }
    }

    @Override
    public void makeTurn(int number, CellValue figure) {
        int i = (number - 1) / size;
        int j = number - i * size - 1;
        grid[i][j] = figure;
    }

    @Override
    public List<Integer> getListEmptyCells() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == CellValue.EMPTY) {
                    int number = getCellsNumb(i, j);
                    list.add(number);
                }
            }
        }
        return list;
    }

    @Override
    public int getSize() {
        return grid.length;
    }

    @Override
    public CellValue getValue(int row, int column) {
        return grid[row][column];
    }

    @Override
    public int getCellsNumb(int i, int j) {
        int a = size - 1;
        int b = 1;
        int result = -1;
        for (int x = 0; x < size; x++) {
            if (i == x) {
                result = i + j + b;
            }
            b += a;
        }
        return result;
    }
}