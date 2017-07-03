package edu.leetcode.easy.string;

/**
 * Created by hungduong on 10/25/16.
 */
public class ImplementStrStr {

    //Naive algorithm: https://www.seas.gwu.edu/~rhyspj/fall09cs144/lab2/lab221.html
    public static int strStrNaive(String haystack, String needle) {
        if((haystack.length() < needle.length())
                || (haystack.length() == 0 && needle.length() != 0))
            return -1;

        if((haystack.length() != 0 && needle.length() == 0)
                || haystack.equals(needle))
            return 0;

        int i = 0, j = 0, pos = 0;
        while(pos < haystack.length()) {
            if(haystack.charAt(pos) == needle.charAt(j)) {
                pos++;
                j++;
            } else {
                j = 0;
                pos = i;
            }

            if(i == pos) {
                i++;
                pos++;
            }

            if(j == needle.length()) {
                return pos - j;
            }
        }

        return -1;
    }

    //Improve Native
    //Complexity: O(nm)
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

    //Solution MP algorithm:

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
        System.out.print(ImplementStrStr.strStrKMP("mississippi", "issip"));
    }
}
