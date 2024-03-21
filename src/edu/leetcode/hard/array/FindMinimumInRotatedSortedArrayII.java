package edu.leetcode.hard.array;

public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi -= 1;
            }
        }

        return nums[lo];
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 1};

        System.out.print(findMin(A));
    }
}
