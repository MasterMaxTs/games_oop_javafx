package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest));
        }
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > this.position().getX() ? 1 : -1;
        int deltaY = dest.getY() > this.position().getY() ? 1 : -1;
        for (int index = 0; index < size; index++) {
                int x = this.position().getX() + (index + 1) * deltaX;
                int y = this.position().getY() + (index + 1) * deltaY;
                steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.getX() - source.getX());
        int deltaY = Math.abs(dest.getY() - source.getY());
        return deltaX == deltaY;


    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
