package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public abstract class King implements Figure {

    private final Cell position;

    public King(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = Math.abs(source.x - dest.x);
        int deltaY = Math.abs(source.y - dest.y);
        Cell[] steps;
        if (!((deltaX == 0 && deltaY == 1) || (deltaY == 0 && deltaX == 1) || (deltaX == 1 && deltaY == 1))) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        steps = new Cell[] {dest};
        return steps;
    }
}
