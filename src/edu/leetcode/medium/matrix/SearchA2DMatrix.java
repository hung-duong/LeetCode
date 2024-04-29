package edu.leetcode.medium.matrix;

/**
 * Created by hungduong on 1/8/17.
 */
public class SearchA2DMatrix {
    // Solution: Binary Search
    // O(log(m + n))
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // We will use the binary search for matrix.
        // Define lo and hi variables before searching
        int lo = 0;
        int hi = m * n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Find the position of element corresponding to mid value
            int r = mid / n;
            int c = mid % n;

            if (target > matrix[r][c]) {
                lo = mid + 1;  // Move to the left
            } else if (target < matrix[r][c]) {
                hi = mid - 1;  // Move to the right
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,3,5,7} ,{10,11,16,20} , {10,11,16,20}};

        searchMatrix(matrix, 3);
    }
}
