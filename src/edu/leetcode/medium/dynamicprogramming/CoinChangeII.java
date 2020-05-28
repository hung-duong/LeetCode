package edu.leetcode.medium.dynamicprogramming;

public class CoinChangeII {
    // https://leetcode.com/problems/coin-change-2/
    // DP with O(n*k) running time and space
    public static int change(int amount, int[] coins) {

        int m = coins.length + 1;
        int n = amount + 1;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i=1; i<n; i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (j >= coins[i-1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m -1][n - 1];
    }

    // DP with O(n*k) space and O(n) space
    public static int changeBetter(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin: coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.print(change(amount, coins));
    }
}
