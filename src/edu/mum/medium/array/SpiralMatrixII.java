package edu.mum.medium.array;

/**
 * Created by hungduong on 1/12/17.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n <= 0)
            return new int[][]{};

        int[][] matrix = new int[n][n];

        int up = 0, down = n - 1, left = 0, right = n - 1;
        int index = 1;
        while(up <= down && left <= right) {
            for(int col = left; col <= right; col++)
                matrix[up][col] = index++;

            if(++up > down)
                break;

            for(int row = up; row <= down; row++)
                matrix[row][right] = index++;

            if(--right < left)
                break;

            for(int col = right; col >= left; col--)
                matrix[down][col] = index++;

            if(--down < up)
                break;

            for(int row = down; row >= up; row--)
                matrix[row][left] = index++;

            if(++left > right)
                break;
        }

        return matrix;
    }
}
