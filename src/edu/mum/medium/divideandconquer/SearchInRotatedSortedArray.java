/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.divideandconquer;

/**
 *
 * @author hungduong
 */
public class SearchInRotatedSortedArray {
    // [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    // Because it's not fully sorted, we can't do normal binary search tree. But we could comes with trick:
    // - If target (for example: 14) we adjust nums where "inf" means infinity
    //      [12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
    // - If target (for example: 7) then we adjust nums
    //      [-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            System.out.println((nums[mid] < nums[0]) + " " + (target < nums[0]) + " => " + ((nums[mid] < nums[0]) == (target < nums[0])));

            int num;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

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

    public static void main(String[] args) {
        int[] nums = {12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int target = 14;
        System.out.print(search(nums, target));
    }
}
