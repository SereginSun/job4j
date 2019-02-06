package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.general.Pawn;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public class PawnBlack extends Pawn {

    public PawnBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
