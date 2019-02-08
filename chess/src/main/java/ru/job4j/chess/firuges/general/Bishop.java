package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 05.02.2019
 */
public abstract class Bishop implements Figure {

    private final Cell position;

    public Bishop(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int size = Math.abs(source.x - dest.x);
        int indexX = source.x;
        int indexY = source.y;
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        Cell[] steps = new Cell[size];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y > dest.y ? -1 : 1;
        for(int index = 0; index != size; index++) {
            indexX = indexX + deltaX;
            indexY = indexY + deltaY;
            steps[index] = findCell(indexX, indexY);
        }
        return steps;
    }

    public static boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = true;
        }
        return result;
    }

    public static Cell findCell(int x, int y) {
        Cell rst = Cell.A1;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                rst = cell;
                break;
            }
        }
        return rst;
    }
}
