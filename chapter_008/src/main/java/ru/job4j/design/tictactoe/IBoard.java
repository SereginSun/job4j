package ru.job4j.design.tictactoe;

import java.util.List;

/**
 * interface IBoard describes the playing field.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface IBoard {

    /**
     * The method of filling the playing field with empty cells.
     */
    void fillGameTable();

    /**
     * The method of making one of the players his own move. A cell under a certain number is assigned a sign (X or O).
     * @param number - the integer number of the cell in which the player places a sign.
     * @param figure - sign (X or O).
     */
    void makeTurn(int number, CellValue figure);

    /**
     * The method for generating a list of all empty cells.
     * @return A list of integer numbers of blank cells.
     */
    List<Integer> getListEmptyCells();

    /**
     * Method of passing the length of cell arrays.
     * @return the integer length of the array of cells on the playing field.
     */
    int getSize();

    /**
     * The method returns the cell value of the playing field by row number and column number.
     * @param row - row number in which the cell is located.
     * @param column - column number in which the cell is located.
     * @return the cell value of the playing field.
     */
    CellValue getValue(int row, int column);

    /**
     * The method returns the integer cell number of the playing field by row number and column number.
     * @param row - row number in which the cell is located.
     * @param column - column number in which the cell is located.
     * @return  the integer cell number of the playing field.
     */
    int getCellsNumb(int row, int column);
}
