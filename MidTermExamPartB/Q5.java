package com.kevinshi721;

import java.util.ArrayList;

public class Q5 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPath(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        }));
        System.out.println(solution.findPath(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        }));
        System.out.println(solution.findPath(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
                {1, 1, 1, 1}
        }));
        System.out.println(solution.findPath(new int[][]{
                {1, 1, 0, 1},
                {1, 0, 1, 1},
                {0, 0, 1, 0},
                {1, 1, 1, 1}
        }));
    }
}

class Solution {
    public ArrayList<Cell> findPath(int[][] maze) {
        return findPath(0, 0, maze, new ArrayList<Cell>());
    }

    private ArrayList<Cell> findPath(int x, int y, int[][] maze, ArrayList<Cell> result) {
        if (maze[x][y] == 0) {
            return new ArrayList<Cell>();
        }
        ArrayList<Cell> localResult = new ArrayList<Cell>(result.subList(0, result.size()));
        localResult.add(new Cell(x, y));
        if (localResult.size() == maze.length * 2 - 1) {
            return localResult;
        }
        if (x < maze.length - 1) {
            ArrayList<Cell> path = findPath(x + 1, y, maze, localResult);
            if (path.size() > 0) {
                return path;
            }
        }
        if (y < maze.length - 1) {
            ArrayList<Cell> path = findPath(x, y + 1, maze, localResult);
            if (path.size() > 0) {
                return path;
            }
        }
        return new ArrayList<Cell>();
    }
}

class Cell{
    int x,y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "["+this.x +", "+this.y+ "]";
    }
}
