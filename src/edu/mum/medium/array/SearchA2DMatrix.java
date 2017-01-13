package edu.mum.medium.array;

/**
 * Created by hungduong on 1/8/17.
 */
public class SearchA2DMatrix {
    //O(log(m + n))
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m*n - 1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int midEle = matrix[mid / n][mid % n];
            if(midEle < target) {
                lo = mid + 1;
            } else if(midEle > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }

        if(target == matrix[lo / n][lo % n]) {
            return true;
        }

        return false;
    }
}
