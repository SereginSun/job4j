package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.general.Queen;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public class QueenBlack extends Queen {

    public QueenBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
