package ru.job4j.design.tictactoe;

/**
 * interface ILogic describes the rules of the Tic-Tac-Toe game.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface ILogic {

    /**
     * The method of handling the player's move.
     * @param figure - sign (X or O).
     * @return value true if there is no winner and there are still free cells, otherwise - false.
     */
    boolean handleTurn(CellValue figure);

    /**
     * The method of getting the winner.
     * @param figure - sign (X or O).
     * @return true if there is a winner, false otherwise.
     */
    boolean getWinner(CellValue figure);

    /**
     * Method to get the winner in a row.
     * @param figure - sign (X or O).
     * @return true if there is a winner in row, false otherwise.
     */
    boolean findWinnerByRow(CellValue figure);

    /**
     * Method to get the winner in a column.
     * @param figure - sign (X or O).
     * @return true if there is a winner in column, false otherwise.
     */
    boolean findWinnerByColumn(CellValue figure);

    /**
     * Method to get the winner in a main diagonal.
     * @param figure - sign (X or O).
     * @return true if there is a winner in a main diagonal, false otherwise.
     */
    boolean findWinnerByMainDiagonal(CellValue figure);

    /**
     * Method to get the winner in a secondary diagonal.
     * @param figure - sign (X or O).
     * @return true if there is a winner in a secondary diagonal, false otherwise.
     */
    boolean findWinnerByNotMainDiagonal(CellValue figure);

    /**
     * A method for checking a draw condition.
     * @return true if there are no free cells, otherwise false.
     */
    boolean isDraw();
}
