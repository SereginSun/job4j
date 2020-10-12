package ru.job4j.design.tictactoe;

/**
 * interface IPlayer - describes the behavior of the players.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public interface IPlayer {

    /**
     * This method describes the player's move.
     */
    void makeTurn();

    /**
     * This method returns the sign (X or O) that the player is using.
     * @return the cell value assigned to the player at the start of the game.
     */
    CellValue getSign();
}
