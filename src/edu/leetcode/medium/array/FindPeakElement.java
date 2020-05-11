package edu.leetcode.medium.array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                ans = nums[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
