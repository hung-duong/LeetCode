package edu.leetcode.easy.string;

public class ValidPalindromeII {
    // O(n^2): Brute force
    public static boolean isPalindrome1(String s) {
        if(s == null || s.length() == 0)
            return true;

        int lo = 0;
        int hi = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();

        while(lo < hi) {
            if(!Character.isLetterOrDigit(chars[lo])) {
                lo++;
            } else if(!Character.isLetterOrDigit(chars[hi])) {
                hi--;
            } else {
                if(chars[lo] == chars[hi]) {
                    lo++;
                    hi--;
                }
            }
        }

        return lo == hi;
    }

    public static boolean validPalindrome1(String s) {
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i < s.length(); i++) {
            char ch = sb.charAt(i);
            sb.deleteCharAt(i);
            if (isPalindrome1(sb.toString()))  return true;
            sb.insert(i, ch);
        }

        return isPalindrome1(sb.toString());
    }

    // O(n): Greedy
    public static boolean isPalindrome2(String str, int low, int high) {
        while (low < high) {
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }

        return true;
    }

    public static boolean validPalindrome2(String str) {
        int low = 0, high = str.length() -  1;
        while (low < high) {
            if (str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return (isPalindrome2(str, low + 1, high) || isPalindrome2(str, low, high - 1));
            }
        }

        return true;
    }
}
