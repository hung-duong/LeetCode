package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/3/17.
 * This algo bases on the Backtracking algorithm (Refer to https://en.wikipedia.org/wiki/Backtracking)
 */
public class PartitionEqualSubsetSum {
    /*
     *This algorithm is similar to subset sum using dynamic programming
     * Refer to: https://www.youtube.com/watch?v=s6FhG--P7z0
     *           http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
     */
    public boolean canPartition01(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        //Get all sum of all elements in array
        int sum = 0;
        for(int e : nums) {
            sum += e;
        }

        if(sum % 2 == 1)
            return false;

        sum /= 2;
        boolean[][] subset = new boolean[nums.length][sum + 1];

        // deal with the first row
        if(nums[0] <= sum)
            subset[0][nums[0]] = true;

        // If sum is 0, then answer is true
        for (int i = 0; i < nums.length; i++)
            subset[i][0] = true;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j < nums[i]) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - nums[i]];
                }
            }
        }

        return subset[nums.length - 1][sum];
    }

    //Improved performance
    public boolean canPartition02(int[] nums) {
        return true;
    }
}
