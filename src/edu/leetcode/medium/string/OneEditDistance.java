package edu.leetcode.medium.string;

public class OneEditDistance {
    // Solution: One Pass Solution
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        for (int i = 0; i < Math.min(m, n); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    // Same length
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (m < n) {
                    // Different length but len(s) < len(t)
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    // Different length but len(s) > len(t)
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }

        return Math.abs(m - n) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb"));
    }
}
