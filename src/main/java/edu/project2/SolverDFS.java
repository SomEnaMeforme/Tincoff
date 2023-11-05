package edu.project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class SolverDFS implements Solver{
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        var adjacency = getAdjacencyList(maze);
        var used = new HashSet<Coordinate>();
        var parents = new HashMap<Coordinate, Coordinate>();
        var stack = new Stack<Coordinate>();
        stack.push(start);
        while(!stack.empty()) {
            var curCell = stack.pop();
            if (curCell.equals(end)) {
                var result = new ArrayList<Coordinate>();
                result.add(end);
                var child = end;
                while(parents.containsKey(child)) {
                    var parent = parents.get(child);
                    result.add(parent);
                }
                return result;
            }
            var children = adjacency.get(curCell).stream().filter(used::contains).toList();
            stack.addAll(children);
            for (var coor : children) {
                parents.put(coor, curCell);
            }
            used.add(curCell);
        }
        return null;
    }

    private HashMap<Coordinate, ArrayList<Coordinate>> getAdjacencyList(Maze maze) {
        var result = new HashMap<Coordinate, ArrayList<Coordinate>>();
        for (var y = 0; y < maze.height; y++)
            for(var x = 0; x < maze.width; x++) {
                var cellCoor = maze.grid[y][x].coor();
                result.put(cellCoor, getConnectedCells(maze, cellCoor));
            }
        return result;
    }
    private ArrayList<Coordinate> getConnectedCells(Maze maze, Coordinate curCell) {
        var connectedCells = new ArrayList<Coordinate>();
        if (curCell.row() > 0 && !maze.grid[curCell.col()][curCell.row() - 1].hasRightWall()) {
            connectedCells.add(maze.grid[curCell.col()][curCell.row() - 1].coor());
        }
        if (curCell.row() < maze.width - 1 && !maze.grid[curCell.col()][curCell.row()].hasRightWall()) {
            connectedCells.add(maze.grid[curCell.col()][curCell.row() + 1].coor());
        }
        if (curCell.col() > 0 && !maze.grid[curCell.col() - 1][curCell.row()].hasLowerWall()) {
            connectedCells.add(maze.grid[curCell.col() - 1][curCell.row()].coor());
        }
        if (curCell.col() < maze.height - 1 && !maze.grid[curCell.col()][curCell.row()].hasLowerWall()) {
            connectedCells.add(maze.grid[curCell.col() + 1][curCell.row()].coor());
        }
        return connectedCells;
    }
}
