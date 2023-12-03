package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Renderer {
    private Renderer() {
    }

    public static void render(Maze maze, List<Coordinate> solve) {
        renderFirstOrLastRow(maze.width);
        var solveSet = solve == null ? new HashSet<Coordinate>() : new HashSet<>(solve);
        for (var i = 0; i < maze.height; i++) {
            renderRow(maze.grid[i], solveSet);
        }
        renderFirstOrLastRow(maze.width);
    }

    public static void renderOnlyMaze(Maze maze) {
        render(maze, new ArrayList<>());
    }

    private final static int ITERATIONS_COUNT = 3;

    private static void renderRow(Cell[] curRow, HashSet<Coordinate> solve) {
        for (var i = 0; i < ITERATIONS_COUNT; i++) {
            renderWallCell(false);
            for (var x = 0; x < curRow.length; x++) {
                var curCell = curRow[x];
                if (curCell.hasLowerWall() && curCell.hasRightWall()) {
                    if (solve.contains(curCell.coor())) {
                        renderSolveCellWithLowerAndRightWall(i);
                    } else {
                        renderCellWithLowerAndRightWall(i);
                    }
                } else if (curCell.hasRightWall()) {
                    if (solve.contains(curCell.coor())) {
                        renderSolveCellWithRightWall();
                    } else {
                        renderCellWithRightWall();
                    }
                } else if (curCell.hasLowerWall()) {
                    if (solve.contains(curCell.coor())) {
                        renderSolveCellWithLowerWall(i);
                    } else {
                        renderCellWithLowerWall(i);
                    }
                } else {
                    if (solve.contains(curCell.coor())) {
                        renderSolveEmptyCell();
                    } else {
                        renderEmptyCell();
                    }
                }
            }
            renderWallCell(true);
        }
    }

    private static void renderFirstOrLastRow(int width) {
        for (var iter = 0; iter < ITERATIONS_COUNT; iter++) {
            for (var i = 0; i < width + 2; i++) {
                renderWallCell(i == width + 1);
            }
        }
    }

    private static final String FILLED_CELL = "■■■";

    @SuppressWarnings("RegexpSinglelineJava")
    private static void renderWallCell(boolean last) {
        System.out.print(FILLED_CELL);
        if (last) {
            System.out.print("\n");
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderRowEnd(boolean last) {
        System.out.print("\n");
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderCellWithRightWall() {
        System.out.print("  ■");
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderEmptyCell() {
        System.out.print("   ");
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderCellWithLowerWall(int iter) {
        switch (iter) {
            case 1, 0 -> System.out.print("   ");
            case 2 -> System.out.print(FILLED_CELL);
            default -> throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderCellWithLowerAndRightWall(int iter) {
        switch (iter) {
            case 1, 0 -> System.out.print("  ■");
            case 2 -> System.out.print(FILLED_CELL);
            default -> throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderSolveCellWithLowerAndRightWall(int iter) {
        switch (iter) {
            case 1, 0 -> System.out.print(" @■");
            case 2 -> System.out.print(FILLED_CELL);
            default -> throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderSolveCellWithLowerWall(int iter) {
        switch (iter) {
            case 1, 0 -> System.out.print(" @ ");
            case 2 -> System.out.print(FILLED_CELL);
            default -> throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderSolveCellWithRightWall() {
        System.out.print(" @■");
    }

    @SuppressWarnings({"RegexpSinglelineJava", "MultipleStringLiterals"})
    private static void renderSolveEmptyCell() {
        System.out.print(" @ ");
    }
}
