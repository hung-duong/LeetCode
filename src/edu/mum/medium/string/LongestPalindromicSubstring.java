package edu.mum.medium.string;

/**
 * Created by hungduong on 9/30/16.
 */
public class LongestPalindromicSubstring {
    /* Solution 01: use DP (O(nxn))
     * If using Brute force solution, O(N^3), The obvious solution is to pick all possible starting and ending positions for a substring, and verify if it is a palindrome.
     * To improve over the brute force solution from a DP approach, first think how we can avoid unnecessary re-computation in validating palindromes.
     * Consider the case “ababa”. If we already knew that “bab” is a palindrome, it is obvious that “ababa” must be a palindrome since the two left and right end letters are the same.
     * Refer to link: http://articles.leetcode.com/longest-palindromic-substring-part-i
     * Youtube: https://www.youtube.com/watch?v=_nCsPn7_OgI
     */
    public static String longestPalindrome01(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        boolean[][] DP = new boolean[n][n];
        //Base case: P[ i, i ] ← true AND P[ i, i+1 ] ← ( Si = Si+1 )
        int longestBegin = 0;
        int maxLen = 1;
        for(int i = 0; i < n; i++)
            DP[i][i] = true;

        for(int i=0; i<n-1; i++) {
            if(chars[i] == chars[i+1]) {
                DP[i][i+1] = true;
                longestBegin = i; //longestBegin at len = 2
                maxLen = 2;
            }
        }

        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(chars[i] == chars[j] && DP[i+1][j-1]) {
                    DP[i][j] = true;
                    longestBegin = i; //longestBegin at len = 3,4, ...,n
                    maxLen = len;
                }
            }
        }

        for(int i = 0; i<s.length(); i++) {
            for(int j = 0; j<s.length(); j++) {
                if(DP[i][j])
                    System.out.print(" " + 1);
                else
                    System.out.print(" " + 0);
            }
            System.out.println();
        }

        return s.substring(longestBegin, longestBegin + maxLen);
    }

    //Use Manacher’s Algorithm (O())
    //Link: http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
    public String longestPalindrome02(String s) {
        return "";
    }

    public static void main(String[] args) {
        String str = "abbabccb";
        String result = longestPalindrome01(str);
        System.out.print(result);
    }
}
