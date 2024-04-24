package edu.leetcode.hard.matrix;

import java.util.HashSet;
import java.util.Set;

public class NQueenII {
    // Solution 1: Backtracking - DFS
    private int size;

    public int totalNQueens(int n) {
        size = n;

        // DFS - Deep First Search
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }


    // Input:
    // 1. col: It is column will place a Queen on next.
    // 2. rows, diagonals, antiDiagonals: They are the HashSet used to store the Queen already placed.
    private int backtrack(int column, Set<Integer> rows, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // Base case: If current column is equal to size, means all Queens have been placed.
        if (column == size) {
            return 1;
        }

        // Loop through the rows for current column. Each row, we try to place a Queen at the square [row, column]:
        //      - Calcualte the diagonal and antiDiagonal for current square [row, column]
        //      - If current row, diagonal and antiDiagonal do place in rows, diagonals and antiDiagonals
        //              => SKIP
        //      - Else: We can place a Queen on this row.
        int totalSolutions = 0;
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

            // Move to next column with board updated
            totalSolutions += backtrack(column + 1, rows, diagonals, antiDiagonals);

            // Remove the Queen from the board since we already explored all the valid paths
            rows.remove(row);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }

        return totalSolutions;
    } 

    //====================================================================================================================================
    //====================================================================================================================================
    // Solution 2: Backtracking - DFS
    // But use boolean array to improve performance
    public int totalNQueens2(int n) {
        size = n;

        boolean[] rows = new boolean[n];
        boolean[] diagonals = new boolean[2*n];
        boolean[] antiDiagonals = new boolean[2*n];

        return backtrack2(0, rows, diagonals, antiDiagonals);
    }


    // Input:
    // 1. col: It is column will place a Queen on next.
    // 2. rows, diagonals, antiDiagonals: They are the HashSet used to store the Queen already placed.
    private int backtrack2(int column, boolean[] rows, boolean[] diagonals, boolean[] antiDiagonals) {
        // Base case: If current column is equal to size, means all Queens have been placed.
        if (column == size) {
            return 1;
        }

        // Loop through the rows for current column. Each row, we try to place a Queen at the square [row, column]:
        //      - Calcualte the diagonal and antiDiagonal for current square [row, column]
        //      - If current row, diagonal and antiDiagonal do place in rows, diagonals and antiDiagonals
        //              => SKIP
        //      - Else: We can place a Queen on this row.
        int totalSolutions = 0;
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

            // Move to next column with board updated
            totalSolutions += backtrack2(column + 1, rows, diagonals, antiDiagonals);

            // Remove the Queen from the board since we already explored all the valid paths
            rows[row] = false;
            diagonals[currDiagonal] = false;
            antiDiagonals[currAntiDiagonal] = false;
        }

        return totalSolutions;
    } 
}
