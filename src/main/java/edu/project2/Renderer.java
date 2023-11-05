package edu.project2;

import java.util.HashSet;
import java.util.List;

public class Renderer {

    public static void render(Maze maze, List<Coordinate> solve) {
        renderFirstOrLastRow(maze.width);
        for (var i = 0; i < maze.height; i++) {
            renderRow(maze.grid[i], solve);
        }
        renderFirstOrLastRow(maze.width);
    }
    private static void renderRow(Cell[] curRow, List<Coordinate> solve) {
        renderWallCell(false);
        for (var x = 0; x < curRow.length; x++){
            var curCell = curRow[x];
            if (curCell.hasLowerWall() && curCell.hasRightWall())
                renderCellWithLowerAndRightWall();
            else if (curCell.hasRightWall())
                renderCellWithRightWall();
            else if (curCell.hasLowerWall())
                renderCellWithLowerWall();
            else
                renderEmptyCell();
        }
        renderWallCell(true);
    }
    private static void renderFirstOrLastRow(int width) {
        for (var i = 0; i < width + 1; i++){
            renderWallCell(i == width);
        }
    }
    private static void renderWallCell(boolean last) {
        System.out.print("■■■");
        System.out.print("■■■");
        System.out.print("■■■");
        if (last) {
            System.out.print("\n");
        }
    }
    private static void renderCellWithRightWall() {
        System.out.print("  ■");
        System.out.print("  ■");
        System.out.print("  ■");
    }
    private static void renderEmptyCell() {
        System.out.print("   ");
        System.out.print("   ");
        System.out.print("   ");
    }
    private static void renderCellWithLowerWall() {
        System.out.print("   ");
        System.out.print("   ");
        System.out.print("■■■");
    }
    private static void renderCellWithLowerAndRightWall() {
        System.out.print("  ■");
        System.out.print("  ■");
        System.out.print("■■■");
    }
}
