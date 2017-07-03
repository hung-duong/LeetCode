package edu.leetcode.medium.divideandconquer;

/**
 * Created by hungduong on 4/29/17.
 */
public class SearchInRotatedSortedArrayII {
    // Same with SearchInRotatedSortedArray but handling for duplicated elements
    // [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    // Target = 14
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;

        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(target == nums[mid]) return true;

            if(nums[mid] > nums[lo]) {
                if(target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if(nums[mid] < nums[lo]) {
                if(target <= nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 2, 2};
        int target = 1;
        System.out.print(search(nums, target));
    }
}
