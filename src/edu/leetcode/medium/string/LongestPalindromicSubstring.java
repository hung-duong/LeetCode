package edu.leetcode.medium.string;

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
     * Complexity: O(n^2)
     * Space: O(n^2)
     */
    public static String longestPalindrome01(String s) {
        if (s == null || s.length() == 0)
            return s;

        int n = s.length();
        char[] chars = s.toCharArray();

        boolean[][] DP = new boolean[n][n];
        //Base case: P[ i, i ] ← true AND P[ i, i+1 ] ← ( Si = Si+1 )
        int longestBegin = 0;
        int maxLen = 1;

        // Consider if len = 1, all character is palindrome
        for(int i = 0; i < n; i++)
            DP[i][i] = true;

        // Consider if len = 2
        for(int i=0; i<n-1; i++) {
            if(chars[i] == chars[i+1]) {
                DP[i][i+1] = true;
                longestBegin = i; //longestBegin at len = 2
                maxLen = 2;
            }
        }

        // Consider if len > 2
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

    // Solution 2: Expend arround center
    // We could resolve this problem by constant time
    // Complexity: O(n^2)
    // Space: O(1)
    public static String longestPalindrome02(String s) {
        if (s == null || s.length() == 0)  return "";

        // Define start and end are the boundary of final string
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            // Handle for case there is the center character like: racecar
            int len1 = expandFromMiddle(s, i, i);

            // Handle for case there is no center character like: aabbaa
            int len2 = expandFromMiddle(s, i, i + 1);

            // Find the longer substring Palindrome
            int len = Math.max(len1, len2);

            if (len > start - end) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right)
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    //Use Manacher’s Algorithm (O())
    //Link: http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
    public String longestPalindrome03(String s) {
        return "";
    }

    public static void main(String[] args) {
        String str = "agbdba";
        String result = longestPalindrome01(str);
        System.out.print(result);
    }
}
