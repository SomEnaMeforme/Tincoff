package edu.project2;

import java.util.Scanner;

public class MazeStart {
    private MazeStart() {
    }

    @SuppressWarnings({"RegexpSinglelineJava", "UncommentedMain"})
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input maze width: ");
        var width = in.nextInt();
        System.out.print("Input maze height: \n");
        var height = in.nextInt();

        var generator = new MazeGenerator();
        var maze = generator.generate(width, height);
        Renderer.renderOnlyMaze(maze);

        System.out.print("Input solve start Coor x: ");
        var x = in.nextInt();
        System.out.print("Input solve start Coor y: \n");
        var y = in.nextInt();
        var start = new Coordinate(y, x);
        System.out.print("Input solve end Coor x: ");
        x = in.nextInt();
        System.out.print("Input solve end Coor y: \n");
        y = in.nextInt();
        var end = new Coordinate(y, x);

        var solve = new SolverDFS().solve(maze, start, end);
        Renderer.render(maze, solve);
    }
}
