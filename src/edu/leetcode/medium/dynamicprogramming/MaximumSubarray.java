package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/5/17.
 */
public class MaximumSubarray {
    //Solution 1: Use DP
    //maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + nums[i];
    public int maxSubArray01(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] DP = new int[nums.length];
        DP[0] = nums[0];
        int max = DP[0];

        for(int i = 1; i < nums.length; i++) {
            DP[i] = nums[i] + (DP[i - 1] > 0 ? DP[i - 1] : 0);
            max = Math.max(max, DP[i]);
        }

        return max;
    }

    //Solution 2: Use Divide and conquer
    public static int maxSubArray02(int[] nums) {
        return 1;
    }
}
