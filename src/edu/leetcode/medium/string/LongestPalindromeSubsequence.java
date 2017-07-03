package edu.leetcode.medium.string;

/**
 * Created by hungduong on 1/28/17.
 */
public class LongestPalindromeSubsequence {
    /* Question: (This this another question of Longest Palindromic Substring above)
     * Given a sequence, find the length of the longest palindromic subsequence in it.
     * For example, if the given sequence is “BBABCBCAB”,
     * then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it
     */

    // Solution 1: The naive solution for this problem is to generate all subsequences of the given sequence and find the longest palindromic subsequence.
    // This solution is exponential in term of time complexity
    // Refer to http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
    public static long longestLengthPalindromeNative(String s) {
        if(s == null || s.length() == 0)
            return 0;

        return lps(s.toCharArray(), 0, s.length() - 1);
    }

    public static int lps(char[] chars, int lo, int hi) {
        if(lo == hi) return 1;
        if(chars[lo] == chars[hi] && lo + 1 == hi) return 2;

        if(chars[lo] == chars[hi])
            return lps(chars, lo + 1, hi - 1) + 2;

        return Math.max(lps(chars, lo + 1, hi), lps(chars, lo, hi - 1));
    }

    //Solution 2: Dynamic Programming Solution (O(nxn) and O(nxn) space)
    //Eg. Input = "abba"                    input: "abcba"
    //    Output maxtrix:                   Output:
    //                  1 1 2 4                     1 1 1 3 5
    //                  0 1 2 2                     0 1 1 3 3
    //                  0 0 1 1                     0 0 1 1 1
    //                  0 0 0 1                     0 0 0 1 1
    //                                              0 0 0 0 1
    public static int longestLengthPalindromeDP(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] L = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (int i = 0; i < n; i++) L[i][i] = 1;

        //l is length of substring
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (chars[i] == chars[j] && l == 2)
                    L[i][j] = 2;
                else if (chars[i] == chars[j])
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                System.out.print(" " + L[r][c]);
            }
            System.out.println();
        }

        return L[0][n-1];
    }

    public static void main(String[] args) {
        String text = "abba";

        long len = longestLengthPalindromeDP(text);
        System.out.print(len);
    }
}
