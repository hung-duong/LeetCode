package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/14/17.
 */
public class MinimumSizeSubarraySum {
    //Use dynamic programming
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int lo = 0, hi;

        for(hi = 0; hi < nums.length; hi++) {
            sum += nums[hi];

            while(sum >= s) {
                minLen = Math.min(hi - lo + 1, minLen);
                sum -= nums[lo];
                lo++;
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print(minSubArrayLen(7, nums));
    }

}
