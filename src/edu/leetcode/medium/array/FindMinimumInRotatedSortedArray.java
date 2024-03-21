package edu.leetcode.medium.array;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int min = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] <= nums[nums.length - 1]) {
                min = nums[mid];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,2,3};

        System.out.print(findMin(nums));
    }
}
