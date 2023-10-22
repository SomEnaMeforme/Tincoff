package edu.hw1.task8;

import java.util.HashSet;

public class Task8 {
    private Task8() {
    }

    private static final int[] POSSIBLE_DELTAS = new int[] {1, -1, 2, -2};

    private static HashSet<Coordinate> getKnightsCoordinate(int[][] board) {
        var knights = new HashSet<Coordinate>();
        for (var rowInd = 0; rowInd < board.length; rowInd++) {
            if (board[rowInd] == null) {
                throw new IllegalArgumentException();
            }
            for (var cellInd = 0; cellInd < board[rowInd].length; cellInd++) {
                if (board[rowInd][cellInd] == 1) {
                    knights.add(new Coordinate(rowInd, cellInd));
                }
            }
        }
        return knights;
    }

    public static boolean knightBoardCapture(int[][] board) throws IllegalArgumentException {
        if (board == null) {
            throw new IllegalArgumentException();
        }
        var knights = getKnightsCoordinate(board);
        for (var knight : knights) {
            for (var dx : POSSIBLE_DELTAS) {
                for (var dy : POSSIBLE_DELTAS) {
                    if (Math.abs(dx) == Math.abs(dy)) {
                        continue;
                    }
                    if (knights.contains(new Coordinate(knight.x() + dx, knight.y() + dy))) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}

