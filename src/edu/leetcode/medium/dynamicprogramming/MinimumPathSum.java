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
    public int minPathSum(int[][] grid) {
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
}
