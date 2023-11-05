package edu.project2;

public class Maze {
    public Maze(int width, int height, Cell[][] grid) {
        this.grid = grid;
        this.height = height;
        this.width = width;
    }
    public final int height;
    public final int width;
    public final Cell[][] grid;
}
