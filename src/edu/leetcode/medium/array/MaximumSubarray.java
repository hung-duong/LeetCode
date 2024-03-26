package edu.leetcode.medium.array;

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

    //Solution 2: Use DP but O(1) space using Kadane's Algorithm
    public static int maxSubArray02(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        
        for (int i=1; i < nums.length; i++) {
            maxEndingHere = nums[i] + (maxEndingHere > 0 ? maxEndingHere : 0);

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }


    //Solution 2: Use Divide and conquer
    public static int maxSubArray03(int[] nums) {
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.print(maxSubArray02(nums));
    }

}
