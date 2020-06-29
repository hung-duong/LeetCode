package edu.leetcode.medium.array;

public class SearchInRotatedSortedArray {
    /*
    https://leetcode.com/problems/search-in-rotated-sorted-array/
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int num = (nums[mid] < nums[lo]) == (target < nums[lo]) ?
                    nums[mid] : target < nums[lo] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if(num < target) {
                lo = mid + 1;
            } else if(num > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return -1;
            } else if (nums[mid] > nums[lo]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
