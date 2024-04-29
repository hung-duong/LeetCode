package edu.leetcode.medium.matrix;

public class MaximalSquare {
    // Solution 1: 2D Array - Dynamic Programming
    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // DP grid to memoize 
        int[][] dp = new int[rows + 1][columns + 1];

        int maxS = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c] == '1') {
                    dp[r + 1][c + 1] = Math.min(Math.min(dp[r][c], dp[r+1][c]), dp[r][c+1]) + 1;
                    maxS = Math.max(maxS, dp[r + 1][c + 1]);
                }
            }
        }

        return maxS * maxS;
    }

    // Solution 2: 1D Array - Dynamic Programming
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // DP grid to memoize 
        int[] dp = new int[columns + 1];

        int maxS = 0;
        int prev = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int temp = dp[c + 1];
                if (matrix[r][c] == '1') {
                    dp[c + 1] = Math.min(Math.min(dp[c], dp[c + 1]), prev) + 1;
                    maxS = Math.max(maxS, dp[c + 1]);
                } else {
                    dp[c + 1] = 0;
                }
                prev = temp;
            }
        }

        return maxS * maxS;
    }
}
