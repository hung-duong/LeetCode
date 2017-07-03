package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/6/17.
 */
public class DecodeWays {
    //It is similar to the problem of couting ways of climbing stairs. DP[n] = DP[n - 1] + DP[n - 2]
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;

        int len = s.length();
        int[] DP = new int[len];
        DP[0] = 1;

        int coupleEles = Integer.parseInt(s.substring(0, 2));
        if(coupleEles <= 26) { //A - > Z = 26 characters
            DP[1] = s.charAt(1) != '0' ? 2 : 1;
        } else {
            DP[1] = s.charAt(1) != '0' ? 1 : 0;
        }

        for(int i = 2; i < len; i++) {
            if(s.charAt(i) != '0') {
                DP[i] += DP[i - 1];
            }

            coupleEles = Integer.parseInt(s.substring(i-1, i+1));
            if(coupleEles <= 26 && coupleEles >= 10) {
                DP[i] += DP[i - 2];
            }
        }

        return DP[len - 1];
    }

    public static void main(String[] args) {
        String s = "1227";
        System.out.print(numDecodings(s));
    }
}
