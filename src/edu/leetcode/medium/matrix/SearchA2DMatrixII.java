package edu.leetcode.medium.matrix;

/**
 * Created by hungduong on 1/8/17.
 */
public class SearchA2DMatrixII {
    // Solution 1: nlog(m) with n is number of rows, and m is number of columns
    // O(1) space
    // This solution will be very BAD solution if n >> m (rows is greater than a lot of columns like [10000000 * 2])
    public boolean searchMatrix1(int[][] matrix, int target) {
        // nlog(m)
        for (int[] arr : matrix) {
            boolean found = searchBinary(arr, target);
            if (found)
                return true;
        }

        return false;
    }

    public boolean searchBinary(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (target < arr[mid]) {
                hi = mid - 1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    // Solution 2: Improved from solution 1
    // This solution will improve previous solution using binary search 
     // Espically if rows >> column like [100000, 2] => Apply binary search for column instead of row
     public boolean searchMatrixImproved(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // If number of rows >> columns -> search by vertical
        boolean vertical = rows > columns ? true : false;

        // If search by vertical is yes, we will use len as number of columns
        int len = vertical ? columns : rows;

        // If vertical is yes -> Apply binary search for column
        //                no -> Apply binary search for rows as normal
        for (int i = 0; i < len; i++) {
            boolean found = searchBinaryImproved(matrix, target, i, vertical);
            if (found)
                return true;
        }

        return false;
    }

    public boolean searchBinaryImproved(int[][] matrix, int target, int start, boolean vertical) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int lo = 0;
        // if search by column the hi will calculate by rows
        // else hi will calculate by columns
        int hi = vertical ? rows - 1 : columns - 1; 
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if (vertical) {
                // Apply binary search for column

                if (target < matrix[mid][start]) {
                    hi = mid - 1;
                } else if (target > matrix[mid][start]) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            } else {
                // Apply binary search for rows
                if (target < matrix[start][mid]) {
                    hi = mid - 1;
                } else if (target > matrix[start][mid]) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    // Solution 3: Search space reduction
    // Complexity: O(m + n)
    // O(1) space
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        //Start from the right-top
        while(row < matrix.length && col >= 0) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
