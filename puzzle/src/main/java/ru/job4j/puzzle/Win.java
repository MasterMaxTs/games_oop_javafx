package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;

public class Win {

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (monoHorizontalCheck(board, i) || monoVerticalCheck(board, i)) {
                    return true;
                }
            }
        }
        return rsl;
    }

    public static boolean monoHorizontalCheck(int[][] board, int row) {
        boolean rsl = true;
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] != 1) {
                return false;
            }
        }
        return rsl;
    }

    public static boolean monoVerticalCheck(int[][] board, int column) {
        boolean rsl = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != 1) {
                return false;
            }
        }
        return rsl;
    }
}
