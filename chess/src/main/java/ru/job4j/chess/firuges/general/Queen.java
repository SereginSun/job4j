package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static ru.job4j.chess.firuges.general.Bishop.isDiagonal;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public abstract class Queen implements Figure {

    private final Cell position;

    public Queen(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int size = Math.abs(deltaX) >= Math.abs(deltaY) ? Math.abs(deltaX) : Math.abs(deltaY);
        int indexX = source.x;
        int indexY = source.y;
        if (!isDiagonal(source, dest) && !isStraight(source, dest)) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        Cell[] steps = new Cell[size];
        if (deltaX == 0) {
            indexX = 0;
        } else {
            indexX = deltaX > 0 ? 1 : -1;
        }

        if (deltaY == 0) {
            indexY = 0;
        } else {
            indexY = deltaY > 0 ? 1 : -1;
        }
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = Cell.values()[(source.x + indexX * i) * 8 + source.y + indexY * i];
        }
        return steps;
    }

    public static boolean isStraight(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        if ((source.y == dest.y && Math.abs(deltaX) > 0) || (source.x == dest.x && Math.abs(deltaY) > 0)) {
            result = true;
        }
        return result;
    }
}
