package edu.project2;

import java.util.Random;

public class MazeGenerator {
    private final Random rnd = new Random();

    public Maze generate(int width, int height) {
        var maze = new CellDescription[height][width];
        CellDescription[] prevRow = null;
        for (var i = 0; i < height; i++) {
            var newRow = i == 0 ? createFirstRow(width) : createNewRow(prevRow, i == height - 1);
            maze[i] = newRow;
            prevRow = newRow;
        }
        return new Maze(width, height, getGrid(maze));
    }

    private Cell[][] getGrid(CellDescription[][] mazeDescription) {
        var height = mazeDescription.length;
        var width = height > 0 ? mazeDescription[0].length : 0;
        var result = new Cell[height][width];
        for (var y = 0; y < height; y++) {
            for (var x = 0; x < width; x++) {
                var desc = mazeDescription[y][x];
                result[y][x] = new Cell(desc.hasRightWall(), desc.hasLowerWall(), new Coordinate(y, x));
            }
        }
        return result;
    }

    private int setCount = 0;

    private CellDescription[] createNewRow(CellDescription[] prevRow, boolean isLast) {
        var newRow = new CellDescription[prevRow.length];
        setCount = createUniqueSetNumber(prevRow, newRow, setCount);
        createRightWall(newRow, isLast);
        if (!isLast) {
            createLowerWall(newRow);
        }
        return newRow;
    }

    private CellDescription[] createFirstRow(int width) {
        var newRow = new CellDescription[width];
        setCount = createUniqueSetNumber(null, newRow, 1);
        createRightWall(newRow, false);
        createLowerWall(newRow);
        return newRow;
    }

    private int createUniqueSetNumber(CellDescription[] prevRow, CellDescription[] curRow, int firstSetNumb) {
        if (prevRow == null) {
            for (var i = 0; i < curRow.length; i++) {
                curRow[i] = new CellDescription(false, false, i + 1);
            }
            return curRow.length;
        } else {
            var nextSet = firstSetNumb;
            for (var i = 0; i < curRow.length; i++) {
                var curSet = prevRow[i].hasLowerWall ? nextSet : prevRow[i].set;
                curRow[i] = new CellDescription(false, false, curSet);
                nextSet = curSet == prevRow[i].set ? nextSet : nextSet + 1;
            }
            return nextSet;
        }
    }

    private void createRightWall(CellDescription[] curRow, boolean isLast) {
        for (var i = 0; i < curRow.length; i++) {
            var hasRightWall = rnd.nextBoolean();
            if (i != curRow.length - 1 && curRow[i].set == curRow[i + 1].set) {
                hasRightWall = true;
            }
            var prev = curRow[i];
            curRow[i] = new CellDescription(hasRightWall, isLast, prev.set);
            if (!hasRightWall && i != curRow.length - 1) {
                mergeSet(curRow, i);
            }
        }
    }

    private void mergeSet(CellDescription[] curRow, int indexCell) {
        var newSet = curRow[indexCell].set;
        var prevSet = curRow[indexCell + 1].set;
        for (var i = indexCell + 1; i < curRow.length; i++) {
            var prevCell = curRow[i];
            if (curRow[i].set == prevSet) {
                curRow[i] = new CellDescription(prevCell.hasRightWall, prevCell.hasLowerWall(), newSet);
            } else {
                break;
            }
        }
    }

    private void createLowerWall(CellDescription[] curRow) {
        for (var i = curRow.length - 1; i >= 0; i--) {
            boolean hasLowerWall = true;//rnd.nextBoolean();
            if (isCellAloneInSet(curRow, i) || isCellAloneInSetWithoutLowerWall(curRow, i)) {
                hasLowerWall = false;
            }
            var prevCell = curRow[i];
            curRow[i] = new CellDescription(prevCell.hasRightWall, hasLowerWall, prevCell.set);
        }
    }

    private boolean isCellAloneInSet(CellDescription[] curRow, int cellInd) {
        var cellSet = curRow[cellInd].set;
        for (var i = curRow.length - 1; i >= 0; i--) {
            if (curRow[i].set == cellSet) {
                return false;
            }
        }
        return true;
    }

    private boolean isCellAloneInSetWithoutLowerWall(CellDescription[] curRow, int cellInd) {
        var cellSet = curRow[cellInd].set;
        var result = true;
        for (var i = cellInd; i < curRow.length; i++) {
            if (curRow[i].set == cellSet && i != cellInd) {
                result = result && curRow[i].hasLowerWall;
            }
        }
        return result;
    }

    private record CellDescription(boolean hasRightWall, boolean hasLowerWall, int set) {
    }
}
