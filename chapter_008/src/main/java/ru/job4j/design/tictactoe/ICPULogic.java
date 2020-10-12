package ru.job4j.design.tictactoe;

/**
 * interface ICPULogic - describes the logic of the player's computer's turn.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface ICPULogic {

    /**
     * Method for accessing a private type field IBoard.
     * @return the value of a field of a class CPULogic of type IBoard.
     */
    IBoard getGrid();

    /**
     * Method of obtaining the cell number for the computer's move.
     * @return integer - cell number.
     */
    int getCellNumb();

    /**
     * The method of trying to win depending on the value of the cell.
     * @param figure - sign (X or O).
     * @return value true if there is a chance of winning this move, otherwise - false.
     */
    boolean tryWin(CellValue figure);

    /**
     * Row win check method.
     * @param figure - sign (X or O).
     * @return value true if there is a chance of winning this move, otherwise - false.
     */
    boolean trySetToRow(CellValue figure);

    /**
     * Column win check method.
     * @param figure - sign (X or O).
     * @return value true if there is a chance of winning this move, otherwise - false.
     */
    boolean trySetToColumn(CellValue figure);

    /**
     * Main Diagonal win check method.
     * @param figure - sign (X or O).
     * @return value true if there is a chance of winning this move, otherwise - false.
     */
    boolean trySetToMainDiagonal(CellValue figure);

    /**
     * The method of checking the winnings along the secondary diagonal.
     * @param figure - sign (X or O).
     * @return value true if there is a chance of winning this move, otherwise - false.
     */
    boolean trySetToNotMainDiagonal(CellValue figure);

    /**
     * Method of obtaining the cell number for a random move of the computer-player.
     * @return integer - cell number.
     */
    int makeRandomComputerTurn();
}
