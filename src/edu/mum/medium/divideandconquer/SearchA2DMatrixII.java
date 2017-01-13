package edu.mum.medium.divideandconquer;

/**
 * Created by hungduong on 1/8/17.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = 0;
        int cols = matrix[0].length - 1;

        //Start from the right-top
        while(rows < matrix.length && cols >= 0) {
            if(target == matrix[rows][cols]) {
                return true;
            } else if(target < matrix[rows][cols]) {
                cols--;
            } else {
                rows++;
            }
        }

        return false;
    }
}
