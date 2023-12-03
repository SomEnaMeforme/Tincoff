package edu.project2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class MazeGenerator {
    private final Random rnd = new Random();
    private Hashtable<Integer, ArrayList<CellDescription>> sets = new Hashtable<>();

    public Maze generate(int width, int height) {
        var maze = new CellDescription[height][width];
        CellDescription[] prevRow = null;
        for (var i = 0; i < height - 1; i++) {
            var newRow = i == 0 ? createFirstRow(width) : createNewRow(prevRow, i == height - 1);
            maze[i] = newRow;
            prevRow = newRow;
        }

        var newRow = createNewRow(prevRow, true);

        for (var i = 0; i < width - 1; i++) {
            if (newRow[i].set != newRow[i + 1].set) {
                var newSet = newRow[i].set;
                newRow[i] = new CellDescription(false, true, newSet);
                var oldSet = newRow[i + 1].set;
                sets.get(oldSet).remove(newRow[i + 1]);
                newRow[i + 1] = new CellDescription(newRow[i + 1].hasRightWall, true, newSet);
                sets.get(newSet).add(newRow[i + 1]);

                mergeSet(newRow, i);
            }
        }
        maze[height - 1] = newRow;

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
        var newRow = copyPrevRow(prevRow);
        setCount = createUniqueSetNumber(prevRow, newRow, setCount);
        createRightWall(newRow, isLast);
        if (!isLast) {
            createLowerWall(newRow);
        }
        return newRow;
    }

    private CellDescription[] copyPrevRow(CellDescription[] prevRow) {
        var newRow = new CellDescription[prevRow.length];
        for (var i = 0; i < prevRow.length; i++) {
            newRow[i] = new CellDescription(false, false,
                prevRow[i].hasLowerWall ? -1 : prevRow[i].set
            );
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
                if (!sets.containsKey(i + 1)) {
                    sets.put(i + 1, new ArrayList<>());
                }
                sets.get(i + 1).add(curRow[i]);
            }
            return curRow.length;
        } else {
            var nextSet = firstSetNumb;
            for (var i = 0; i < curRow.length; i++) {
                if (curRow[i].set == -1) {
                    curRow[i] = new CellDescription(false, false, nextSet);
                    if (!sets.containsKey(nextSet)) {
                        sets.put(nextSet, new ArrayList<>());
                    }
                    sets.get(nextSet).add(curRow[i]);
                    nextSet++;
                }
//                var curSet = prevRow[i].hasLowerWall ? nextSet : prevRow[i].set;
//                curRow[i] = new CellDescription(false, false, curSet);
//                nextSet = curSet == prevRow[i].set ? nextSet : nextSet + 1;
//                if (!sets.containsKey(curSet))
//                    sets.put(curSet, new ArrayList<>());
//                sets.get(curSet).add(curRow[i]);
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
                if (!sets.containsKey(newSet)) {
                    sets.put(newSet, new ArrayList<>());
                }
                sets.get(newSet).add(curRow[i]);
            } else {
                break;
            }
        }
    }

    private void createLowerWall(CellDescription[] curRow) {
        for (var i = 0; i < curRow.length; i++) {
            boolean hasLowerWall = rnd.nextBoolean();
            if (isCellAloneInSet(curRow, i) || isCellAloneInSetWithoutLowerWall(curRow, i)) {
                hasLowerWall = false;
            }
            var prevCell = curRow[i];
            curRow[i] = new CellDescription(prevCell.hasRightWall, hasLowerWall, prevCell.set);
        }
    }

    private boolean isCellAloneInSet(CellDescription[] curRow, int cellInd) {
        var cellSet = curRow[cellInd].set;
        return sets.get(cellSet).size() == 1;
    }

    private boolean isCellAloneInSetWithoutLowerWall(CellDescription[] curRow, int cellInd) {
        var cellSet = curRow[cellInd].set;
        return sets.get(cellSet).stream().filter(x -> x.hasLowerWall).count() > 1;
    }

    private record CellDescription(boolean hasRightWall, boolean hasLowerWall, int set) {
    }
}
