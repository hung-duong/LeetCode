package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/14/17.
 */
public class MinimumSizeSubarraySum {
    //Use Sliding window
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.print(minSubArrayLen(7, nums));
    }

}
