package edu.leetcode.medium.string;

public class PalindromicSubstrings {
    
    // Solution 1: Brute force
    // O(n^3)
    public boolean isPalindrom(String s, int left, int right) {

        while(left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    public int countSubstrings01(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrom(s, i, j))
                    count++;
            }
        }

        return count;
    }

    // Solution 2: How to imrpove?
    // Basically if we know a string is Palindrome and I divide it in 2 parts (if length is even) that would have
    // same characters and for odd length execept the middle element, all the character would be the same
    // s = abba => ab  & ba
    // s = abcba => ab & c & ba
    public int countPalindrom(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            count++;

        return count;
    }

    public int countSubstrings02(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int even = countPalindrom(s, i, i+1);
            int odd = countPalindrom(s, i-1, i+1);

            count += even + odd + 1;
        }

        return count;
    }

    // Solution 3: Dynamic Programing
    public int countSubstrings03(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] DP = new int[n][n];
        int count = 0;

        // If len = 1
        for (int i=0; i<n; i++) {
            DP[i][i] = 1;
            count++;
        }

        // If len = 2
        for(int i=0; i<n-1; i++) {
            if(chars[i] == chars[i+1]) {
                DP[i][i+1] = 1;
                count++;
            }
        }

        // If len > 3
        for(int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (chars[i] == chars[j] && DP[i+1][j-1] == 1) {
                    DP[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main (String[] args) {
        String s = "ababa";
        PalindromicSubstrings ps = new PalindromicSubstrings();

        System.out.print(ps.countSubstrings03(s));
    }
}
