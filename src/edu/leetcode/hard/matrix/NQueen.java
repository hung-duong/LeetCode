package edu.leetcode.hard.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    // Solution: Backtracking - DFS
    private Integer size;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] board = new char[n][n];

        // Set char '.' in every cells in board
        for(char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        // DFS - Deep First Search
        backtrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());

        return ans;
    }

    // BuildSolution is the function used to build results if solution is found
    // Mean that all Queen found the right place in board to place
    private List<String> buildSolution(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }  

    // Input:
    // 1. board: Matrix to keep actual board, then when find the solution, we can include it in the anwser.
    // 2. col: It is column will place a Queen on next.
    // 3. rows, diagonals, antiDiagonals: They are the HashSet used to store the Queen already placed.
    private void backtrack(char[][] board, int column, Set<Integer> rows, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // If current column is equal to size, mean that we have a solution.
        // Add solution in the anwser and return.
        if (column == size) {
            ans.add(buildSolution(board));
            return;
        }

        // Loop through the rows for current column. Each row, we try to place a Queen at the square [row, column]:
        //      - Calcualte the diagonal and antiDiagonal for current square [row, column]
        //      - If current row, diagonal and antiDiagonal do place in rows, diagonals and antiDiagonals
        //              => SKIP
        //      - Else: We can place a Queen on this row.
        for (int row = 0; row < size; row++) {
            int currDiagonal = row - column;
            int currAntiDiagonal = row + column;
            if (rows.contains(row) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;  // SKIP
            }

            // Place Queen on this square [row, column]
            rows.add(row);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            board[row][column] = 'Q';

            // Move to next column with board updated
            backtrack(board, column + 1, rows, diagonals, antiDiagonals);

            // Remove the Queen from the board since we already explored
            // All the valid paths
            rows.remove(row);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            board[row][column] = '.';
        }
    }

    // Solution 2: Backtracking - DFS
    // But use boolean array to improve performance
    public List<List<String>> solveNQueens2(int n) {
        size = n;
        char[][] board = new char[n][n];
        boolean[] rows = new boolean[n];
        boolean[] diagonals = new boolean[2*n];
        boolean[] antiDiagonals = new boolean[2*n];

        // Set char '.' in every cells in board
        for(char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        // DFS - Deep First Search
        backtrack2(board, 0, rows, diagonals, antiDiagonals);

        return ans;
    }

    // BuildSolution is the function used to build results if solution is found
    // Mean that all Queen found the right place in board to place
    private List<String> buildSolution2(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }  

    // Input:
    // 1. board: Matrix to keep actual board, then when find the solution, we can include it in the anwser.
    // 2. column: It is column will place a Queen on next.
    // 3. rows, diagonals, antiDiagonals: They are the HashSet used to store the Queen already placed.
    private void backtrack2(char[][] board, int column, boolean[] rows, boolean[] diagonals, boolean[] antiDiagonals) {
        // If current column is equal to size, mean that we have a solution.
        // Add solution in the anwser and return.
        if (column == size) {
            ans.add(buildSolution2(board));
            return;
        }

        // Loop through the rows for current column. Each row, we try to place a Queen at the square [row, column]:
        //      - Calcualte the diagonal and antiDiagonal for current square [row, column]
        //      - If current row, diagonal and antiDiagonal do not place in rows, diagonals and antiDiagonals
        //              => We can place a Queen on this row.
        //      - Else => Skip
        for (int row = 0; row < size; row++) {
            int currDiagonal = row - column + size;
            int currAntiDiagonal = row + column;
            if (rows[row] || diagonals[currDiagonal] || antiDiagonals[currAntiDiagonal]) {
                continue;  // SKIP
            }

            // Place Queen on this square [row, column]
            rows[row] = true;
            diagonals[currDiagonal] = true;
            antiDiagonals[currAntiDiagonal] = true;
            board[row][column] = 'Q';

            // Move to next column with board updated
            backtrack2(board, column + 1, rows, diagonals, antiDiagonals);

            // Remove the Queen from the board since we already explored all the valid paths
            rows[row] = false;
            diagonals[currDiagonal] = false;
            antiDiagonals[currAntiDiagonal] = false;
            board[row][column] = '.';
        }
    }
}
