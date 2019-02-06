package ru.job4j.chess.firuges.general;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static ru.job4j.chess.firuges.general.Queen.isStraight;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public abstract class Rook implements Figure {

    private final Cell position;

    public Rook(final Cell position) {
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
        int size = dest.x - source.x != 0 ? Math.abs(deltaX) : Math.abs(deltaY);
        if (!(isStraight(source, dest))) {
            throw new ImpossibleMoveException("Фигура не может так ходить.");
        }
        Cell[] steps = new Cell[size];
        if (deltaX != 0) {
            int indexX = deltaX > 0 ? 1 : -1;
            for (int index = 0; index != size; index++) {
                for (Cell cell : Cell.values()) {
                    if (cell.x == source.x + indexX * (index + 1) && cell.y == source.y) {
                        steps[index] = cell;
                        break;
                    }
                }
            }
        } else {
            int indexY = deltaY > 0 ? 1 : -1;
            for (int index = 0; index != size; index++) {
                for (Cell cell : Cell.values()) {
                    if (cell.x == source.x && cell.y == source.y + indexY * (index + 1)) {
                        steps[index] = cell;
                        break;
                    }
                }
            }
        }
        return steps;
    }
}
