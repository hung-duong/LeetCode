package edu.leetcode.medium.dynamicprogramming;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp2[1] = nums[1];

        int preHouse = 0;
        for (int h = 1; h < nums.length - 1; h++) {
            dp1[h] = Math.max(preHouse + nums[h], dp1[h-1]);
            preHouse = dp1[h-1];
        }

        preHouse = 0;
        for (int h=2; h < nums.length; h++) {
            dp2[h] = Math.max(preHouse + nums[h], dp2[h-1]);
            preHouse = dp2[h-1];
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.print(rob(nums));
    }
}
