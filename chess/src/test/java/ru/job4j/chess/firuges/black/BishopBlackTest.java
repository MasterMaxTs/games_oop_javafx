package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell expected = Cell.C8;
        Figure bishopBlack  = new BishopBlack(expected);
        Cell rsl = bishopBlack.position();
        assertEquals(expected, rsl);


    }

    @Test
    public void whenMoveFromC8ToG4() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.G4;
        Cell[] rsl = bishopBlack.way(dest);
        Cell[] expected = {Cell.D7, Cell.E6, Cell.F5, Cell.G4};
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenMoveFromE4ToB7() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.E4);
        Cell dest = Cell.B7;
        Cell[] rsl = bishopBlack.way(dest);
        Cell[] expected = {Cell.D5, Cell.C6, Cell.B7};
        assertThat(rsl, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenWrongWayFromC8ToF6() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.F6;
        Cell[] rsl = bishopBlack.way(dest);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void WhenWrongWayFromC8ToC7() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell dest = Cell.C7;
        Cell[] rsl = bishopBlack.way(dest);
    }

    @Test
    public void whenCreateFigureToE6() {
        Cell source = Cell.C8;
        Cell expectedDest = Cell.E6;
        Figure bishopBlack  = new BishopBlack(source);
        Cell rsl = bishopBlack.copy(expectedDest).position();
        assertEquals(expectedDest, rsl);

    }


}