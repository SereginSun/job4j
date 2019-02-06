package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.general.King;

/**
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.01.2019
 */
public class KingBlack extends King {

    public KingBlack(final Cell position) {
        super(position);
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
