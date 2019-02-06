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
public abstract class Pawn implements Figure {

    private final Cell position;

    public Pawn(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (!(source.y == dest.y + 1 && source.x == dest.x)) {
            steps = new Cell[] {dest};
        } else {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        return steps;
    }
}
