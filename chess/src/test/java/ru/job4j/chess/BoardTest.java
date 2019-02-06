package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.02.2019
 */
public class BoardTest {

    @Test
    public void whenBishopMoveFromF1ToH3ThenTrue() {
        Board board = new Board();
        board.add(new BishopBlack(Cell.F1));
        assertThat(board.move(Cell.F1, Cell.H3), is(true));
    }

    @Test
    public void whenBishopMoveFromF1ToC4ThenFalse() {
        Board board = new Board();
        board.add(new BishopBlack(Cell.F1));
        board.add(new PawnBlack(Cell.E2));
        try {
            board.move(Cell.F1, Cell.C4);
        } catch (OccupiedWayException owe) {
            Assert.assertThat(owe.getMessage(), is("Путь занят!"));
        }
    }

    @Test
    public void whenBishopMoveFromC1ToC4ThenFalse() {
        Board board = new Board();
        board.add(new BishopBlack(Cell.C1));
        try {
            board.move(Cell.C1, Cell.C4);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenKingMoveFromE1ToE2ThenTrue() {
        Board board = new Board();
        board.add(new KingBlack(Cell.E1));
        assertThat(board.move(Cell.E1, Cell.E2), is(true));
    }

    @Test
    public void whenKingMoveFromE1ToF1ThenTrue() {
        Board board = new Board();
        board.add(new KingBlack(Cell.E1));
        assertThat(board.move(Cell.E1, Cell.F1), is(true));
    }

    @Test
    public void whenKingMoveFromE1ToF2ThenTrue() {
        Board board = new Board();
        board.add(new KingBlack(Cell.E1));
        assertThat(board.move(Cell.E1, Cell.F2), is(true));
    }

    @Test
    public void whenKingMoveFromE1ToG3ThenFalse() {
        Board board = new Board();
        board.add(new KingBlack(Cell.E1));
        try {
            board.move(Cell.E1, Cell.G3);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenKingMoveFromE1ToE7ThenFalse() {
        Board board = new Board();
        board.add(new KingBlack(Cell.E1));
        try {
            board.move(Cell.E1, Cell.E7);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenKnightMoveFromB1ToC3ThenTrue() {
        Board board = new Board();
        board.add(new KnightBlack(Cell.B1));
        board.add(new PawnBlack(Cell.B2));
        assertThat(board.move(Cell.B1, Cell.C3), is(true));
    }

    @Test
    public void whenKnightMoveFromB1ToC3ThenFalse() {
        Board board = new Board();
        board.add(new PawnBlack(Cell.D2));
        try {
            board.move(Cell.B1, Cell.C3);
        } catch (FigureNotFoundException fnfe) {
            Assert.assertThat(fnfe.getMessage(), is("В заданой ячейке нет фигуры!"));
        }
    }

    @Test
    public void whenKnightMoveFromB1ToC7ThenFalse() {
        Board board = new Board();
        board.add(new KnightBlack(Cell.B1));
        try {
            board.move(Cell.B1, Cell.C7);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenPawnMoveFromD2ToD3ThenTrue() {
        Board board = new Board();
        board.add(new PawnBlack(Cell.D2));
        assertThat(board.move(Cell.D2, Cell.D3), is(true));
    }

    @Test
    public void whenPawnMoveFromD2ToE2ThenFalse() {
        Board board = new Board();
        board.add(new PawnBlack(Cell.D2));
        try {
            board.move(Cell.D2, Cell.E2);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenPawnMoveFromD2ToE3ThenFalse() {
        Board board = new Board();
        board.add(new PawnBlack(Cell.D2));
        try {
            board.move(Cell.D2, Cell.E3);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenQueenMoveFromD1ToD7ThenFalse() {
        Board board = new Board();
        board.add(new QueenBlack(Cell.D1));
        board.add(new PawnBlack(Cell.D5));
        try {
            board.move(Cell.D1, Cell.D7);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenQueenMoveFromD1ToD5ThenTrue() {
        Board board = new Board();
        board.add(new QueenBlack(Cell.D1));
        assertThat(board.move(Cell.D1, Cell.D5), is(true));
    }

    @Test
    public void whenQueenMoveFromD1ToA1ThenTrue() {
        Board board = new Board();
        board.add(new QueenBlack(Cell.D1));
        assertThat(board.move(Cell.D1, Cell.A1), is(true));
    }

    @Test
    public void whenQueenMoveFromD1ToG4ThenTrue() {
        Board board = new Board();
        board.add(new QueenBlack(Cell.D1));
        assertThat(board.move(Cell.D1, Cell.G4), is(true));
    }

    @Test
    public void whenQueenMoveFromD1ToF5ThenFalse() {
        Board board = new Board();
        board.add(new QueenBlack(Cell.D1));
        try {
            board.move(Cell.D1, Cell.F5);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenRookMoveFromA1ToA5ThenTrue() {
        Board board = new Board();
        board.add(new RookBlack(Cell.A1));
        assertThat(board.move(Cell.A1, Cell.A5), is(true));
    }

    @Test
    public void whenRookMoveFromA1ToE1ThenTrue() {
        Board board = new Board();
        board.add(new RookBlack(Cell.A1));
        assertThat(board.move(Cell.A1, Cell.E1), is(true));
    }

    @Test
    public void whenRookMoveFromA1ToD3ThenFalse() {
        Board board = new Board();
        board.add(new RookBlack(Cell.A1));
        try {
            board.move(Cell.A1, Cell.D3);
        } catch (ImpossibleMoveException ime) {
            Assert.assertThat(ime.getMessage(), is("Фигура не может так ходить."));
        }
    }

    @Test
    public void whenRookMoveFromA1ToA7ThenFalse() {
        Board board = new Board();
        board.add(new RookBlack(Cell.A1));
        board.add(new PawnBlack(Cell.A5));
        try {
            board.move(Cell.A1, Cell.A7);
        } catch (OccupiedWayException owe) {
            Assert.assertThat(owe.getMessage(), is("Путь занят!"));
        }
    }
}