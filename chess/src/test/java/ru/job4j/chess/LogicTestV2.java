package ru.job4j.chess;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.junit.Assert.*;

public class LogicTestV2 {

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCellByPawnBlackD7() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.D7));
        logic.move(Cell.C8, Cell.G4);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenBishopBlackHavePositionB7() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B7));
        logic.move(Cell.C8, Cell.G4);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWrongWayFromF5ToC6() throws FigureNotFoundException,
            OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F5));
        logic.move(Cell.F5, Cell.C6);
    }
}