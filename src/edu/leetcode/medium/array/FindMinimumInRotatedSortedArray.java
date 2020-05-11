package edu.leetcode.medium.array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[nums.length - 1]) {
                ans = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
