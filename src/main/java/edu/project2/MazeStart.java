package edu.project2;

import java.util.Scanner;

public class MazeStart {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input maze width: ");
        var width = 5;//in.nextInt();
        System.out.print("Input maze height: \n");
        var height = 5;//in.nextInt();

        var generator = new MazeGenerator();
        var maze = generator.generate(width, height);
        var solve = new SolverDFS().solve(maze, new Coordinate(0, 0), new Coordinate(width - 1, height - 1));
        Renderer.render(maze, solve);
    }
}
