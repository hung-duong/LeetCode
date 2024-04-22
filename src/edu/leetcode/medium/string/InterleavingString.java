package edu.leetcode.medium.string;

public class InterleavingString {

    // Solution 1: 2D (Matrix) - Dynamic Programming
    public boolean isInterleave1(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if (n + m != k) {
            return false;
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // Case: s1 = "", s2 = "", s3 = ""

        //Base case
        // 1. Fill first row of DP array, considering only the characters from S1
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // 2. Fill first column of DP array, considering only the characters from S2
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // DP Loop
        for (int i = 1; i <= n; i++) {
            for (int j = 1;  j <= m; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[n][m];
    }

    // Solution 2: 1D (Array) - Dynamic Programming
    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if (n + m != k) {
            return false;
        }

        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        //Base case
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // DP Loop
        for (int i = 1; i <= n; i++) {
            dp[0] = dp[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                dp[j] = (dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(isInterleave(s1, s2, s3));
    }

}
