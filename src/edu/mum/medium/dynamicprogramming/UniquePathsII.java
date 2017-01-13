package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 10/16/16.
 */
public class  UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        if(row == 0 || obstacleGrid[row - 1][column - 1] == 1)
            return 0;

        int[] Q = new int[column + 1];
        Q[0] = 0;

        boolean found = false;
        for(int i = 1; i < column + 1; i++) {
            if(obstacleGrid[0][i - 1] == 1)
                found = true;

            if(found) {
                Q[i] = 0;
            } else {
                Q[i] = 1;
            }
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column + 1; j++) {
                if(obstacleGrid[i][j - 1] == 1)
                    Q[j] = 0;
                else
                    Q[j] = Q[j] + Q[j - 1];
            }
        }

        return Q[column];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0}, { 1, 0}};

        System.out.print(UniquePathsII.uniquePathsWithObstacles(obstacleGrid));
    }
}
