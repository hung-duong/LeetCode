package edu.leetcode.easy.string;

/**
 * Created by hungduong on 10/25/16.
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
public class FindIndexOfFirstOccurenceInString {

    // Solution 1.1: Sliding Window (Naive Approach)
    public int strStrNaive(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();

        if (lenN > lenH) {
            return -1;
        }
        
        for(int window = 0; window <= lenH - lenN; window++) {
            boolean found = true;
            for (int pos = 0; pos < lenN && found; pos++) {
                if (haystack.charAt(pos + window) != needle.charAt(pos)) {
                    found = false;
                }
            }

            if (found) {
                return window;
            }
        }

        return -1;
    }

    // Solution 1.2: Sliding Window (Naive Approach)
    // Same above but different code a little
    public static int strStrNativeImproved(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if((n < m) || (n == 0 && m != 0))
            return -1;

        if((n != 0 && m == 0) || haystack.equals(needle))
            return 0;

        for(int i = 0; i <= n - m; i++) {
            int j = 0;
            while(haystack.charAt(i + j) == needle.charAt(j)) {
                if(j == m - 1)
                    return i;
                else
                    j++;
            }
        }

        return -1;
    }

    //Solution Kabin-Karp algorithm:
    public int hashValue(String input, int radix, int mod, int m) {
        int ans = 0;
        long factor = 1;
        for(int i = m - 1; i >= 0; i--) {
            ans += ((int) (input.charAt(i) - 'a') * factor ) % mod;
            factor = (factor * radix) % mod;
        }

        return ans % mod;
    }

    public int strStrKP(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();

        if (lenN > lenH)
            return -1;

        // Define constants
        int radix = 26;
        int mod = 1000000033;
        long max_weight = 1;

        // Compute hash of needle
        for (int i = 0; i < lenN; i++) {
            max_weight = (max_weight * radix) % mod;
        }
        long hashNeedle = hashValue(needle, radix, mod, lenN);

        long hashHaystack = 0;
        for(int window = 0; window <= lenH - lenN; window++) {
            // If window just start -> compute by hash_value function
            if (window == 0) {
                hashHaystack = hashValue(haystack, radix, mod, lenN);
            } else {
                // Update has using previous hash value in O(1)
                hashHaystack = (hashHaystack * radix) % mod;
                hashHaystack -= ((int) (haystack.charAt(window - 1) - 'a') * max_weight) % mod;
                hashHaystack += (int) (haystack.charAt(window + lenN - 1) - 'a') + mod;
                hashHaystack %= mod;
            }

            // If the hash matches, check character by character
            if (hashHaystack == hashNeedle) {
                boolean found = true;
                for (int i = 0; i < lenN && found; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + window)) {
                        found = false;
                    }
                }
                if(found) {
                    return window;
                }
            }
        }

        return -1;
    }

    //Solution KMP algorithm: https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm
    public static int strStrKMP(String haystack, String needle) {
        int lenS = haystack.length();
        int lenW = needle.length();

        if((lenS < lenW) || (lenS == 0 && lenW != 0))
            return -1;

        if((lenS != 0 && lenW == 0) || haystack.equals(needle))
            return 0;

        int m = 0, i = 0;
        int[] T = kmpTable(needle);

        while(m + i < lenS) {
            if(haystack.charAt(m + i) == needle.charAt(i)) {
                if(i == lenW - 1)
                    return m;
                i++;
            } else {
                if(T[i] > -1) {
                    m = m + i - T[i];
                    i = T[i];
                } else {
                    m++;
                    i = 0;
                }
            }
        }

        return -1;
    }

    public static int[] kmpTable(String needle) {
        int lenW = needle.length();

        if (lenW == 1) return new int[]{-1};

        int[] T = new int[lenW];
        T[0] = -1;
        T[1] = 0;

        int pos = 2, cnd = 0;

        while(pos < lenW) {
            if (needle.charAt(pos - 1) == needle.charAt(cnd)) {
                T[pos] = cnd + 1;
                pos++;
                cnd++;
            } else if(cnd > 0) {
                cnd = T[cnd];
            } else {
                T[pos] = 0;
                pos++;
            }
        }

        return T;
    }

    public static void main(String[] args) {
        System.out.print(FindIndexOfFirstOccurenceInString.strStrKMP("mississippi", "issip"));
    }
}
