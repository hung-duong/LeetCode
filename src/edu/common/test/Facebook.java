package edu.common.test;

public class Facebook {

    /*
    Find the first and last position of X in Sorted Array
    Eg.
         N = 9
         Arr = 2, 3, 4, 7, 7, 8, 8, 8, 12
         X = 8   =>  return [5, 7]
         X = 5   =>  return [-1, -1]
     */

    public int firstPos(int[] num, int x) {
        int first_pos = num.length;
        int low = 0, high = num.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] >= x) {
                first_pos = mid;
                high = high  - 1;
            } else {
                low = low + 1;
            }
        }

        return first_pos;
    }

    public int[] searchRange(int[] arr, int x) {
        int first = firstPos(arr, x);
        int last = firstPos(arr, x + 1) - 1;

        return new int[]{first, last};
    }




}
