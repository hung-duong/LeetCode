package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 7/26/17.
 */
public class LongestCommonSubstring {
    /**
     * http://www.geeksforgeeks.org/longest-common-substring/
     * Solution 1: A simple solution, is to one by one consider all substrings of first string and for every substring check
     * if it is a substring in second string. Keep track of the maximum length substring. There will be O(m^2) substrings and
     * we can find whether a string is subsring on another string in O(n) time (See this). So overall time complexity of this
     * method would be O(n * m^2)
     */
    public static int LCS01(String str1, String str2) {
        return 0;
    }

    /**
     * Solution 2: DP => find the longest common substring in O(m*n) time. The idea is to find length of the longest common
     * suffix for all substrings of both strings and store these lengths in a table.
     */
    public static int LCS02(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j<=n; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
