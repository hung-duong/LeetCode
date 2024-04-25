package edu.leetcode.medium.matrix;

/**
 * Created by hungduong on 10/16/16.
 */
public class  UniquePathsII {
    // Solution 1: 1D Array - Dynamic Programming
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        // If there is obstack at destination => can not reach to destination
        if(obstacleGrid[rows - 1][columns - 1] == 1)
            return 0;

        int[] paths = new int[columns + 1];

        // 1. For the first row, the paths will be calcualte
        // path[0] = 0
        // paths[i] = 0, if obstacleGrid[0][i-1] == 1 || (i != 1 && paths[i - 1] == 0)
        // paths[i] = 1, if else 
        paths[0] = 0;
        for(int i = 1; i < columns + 1; i++) {
            paths[i] = obstacleGrid[0][i - 1] == 1 || (i != 1 && paths[i - 1] == 0) ? 0 : 1;
        }

        // 2. From the second row
        // paths[j] = 0, if obstacleGrid[i][j-1] == 1
        // paths[j] = paths[j] + paths[j - 1], if obstacleGrid[i][j-1] == 0
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns + 1; j++) {
                if(obstacleGrid[i][j - 1] == 1)
                    paths[j] = 0;
                else
                    paths[j] = paths[j] + paths[j - 1];
            }
        }

        return paths[columns];
    }

    // Solution 2: Dynamic Programming with O(1) space
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;

        // If there is obstack at destination => can not reach to destination
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][columns - 1] == 1)
            return 0;

        // Number of ways of reach the start cell = 1
        obstacleGrid[0][0] = 1;

        // Filling value for first row
        for(int j = 1; j < columns; j++) {
            obstacleGrid[0][j] = obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1? 1 : 0;
        } 

        // Filling value for first column
        for(int i = 1; i < rows; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1? 1 : 0;
        } 

        // 2. From the second row
        // obstacleGrid[i][j] = 0, if obstacleGrid[i][j] == 1
        // obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1], if obstacleGrid[i][j] == 0
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns; j++) {
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0}, { 1, 0}};

        System.out.print(UniquePathsII.uniquePathsWithObstacles1(obstacleGrid));
    }
}
