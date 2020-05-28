package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/5/17.
 */
public class MinimumPathSum {
    /*
     * 0  1  3  5  7          0  1  4  9  16
     * 6  7  10 1  8    =>    6  8  14 10 18
     * 9  15 30 10 2          15 23 44 20 20
     * 1  8  9  4  10         16 26 35 24 30
     */
    //O(m*n) and O(n) space
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[]  Q = new int[n];

        //Sum successive of first row
        Q[0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            Q[i] = grid[0][i] + Q[i - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //Sum successive of first column
                if(j == 0) {
                    Q[j] += grid[i][j];
                } else {
                    int min = Q[j] < Q[j - 1] ? Q[j] : Q[j - 1];
                    Q[j] = min + grid[i][j];
                }
            }
        }

        return Q[n - 1];
    }

    //O(m*n) and O(m*n) space
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                dp[i][j] += grid[i][j];

                if (i > 0 && j>0) {
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i == 0) {
                    dp[i][j] += dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
