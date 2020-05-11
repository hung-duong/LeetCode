package edu.leetcode.easy.dynamicprogramming;

public class MinCostClimbingStairs {
    /*
    https://leetcode.com/problems/min-cost-climbing-stairs/
     */
    // Forward (Bottom up)
    // O(n) and O(n) space
    static public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

    // Backward
    // ON(n) and O(1) space
    static public int minCostClimbingStairs2(int[] cost) {
        int f1 = 0, f2 = 0;

        for (int i=cost.length - 1; i>=0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }

        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0};

        System.out.print(minCostClimbingStairs1(nums));
    }
}
