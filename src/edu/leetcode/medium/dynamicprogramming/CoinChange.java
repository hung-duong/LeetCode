package edu.leetcode.medium.dynamicprogramming;

public class CoinChange {
    // https://leetcode.com/problems/coin-change/
    // DP
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            dp[i] = amount + 1;
        }

        for (int i=1; i<=amount; i++) {
            for(int num : coins) {
                if (i - num >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        System.out.print(coinChange(coins, amount));
    }
}
