package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 3/2/17.
 * https://shanzi.gitbooks.io/algorithm-notes/content/problem_solutions/cheapest_palindrome.html
 */
public class CheapestPalindrome {
    //Solution 1: O(n^2) running time and O(n^2) spaces
    public static int solve01(String str) {
        int[][] DP = new int[str.length()][str.length()];

        for(int i = 0; i < str.length(); i++) {
            DP[i][i] = 0;
        }

        for(int j = 1; j < str.length(); j++) {
            for(int i = j-1; i >= 0; i--) {
                if(str.charAt(i) == str.charAt(j)) {
                    DP[i][j] = DP[i+1][j-1];
                } else {
                    DP[i][j] = Math.min(DP[i+1][j], DP[i][j-1]) + 1;
                }
            }
        }

        return DP[0][str.length() - 1];
    }

    //Solution 2: O(n^2) running time and O(n) spaces
    public static int solve02(String str) {
        int n = str.length();
        int[] DP1 = new int[n];  //Rows
        int[] DP2 = new int[n];  //Columns

        for(int j = 1; j < str.length(); j++) {
            for(int i = j-1; i >= 0; i--) {
                if(str.charAt(i) == str.charAt(j)) {
                    DP1[i] = DP2[i+1];
                } else {
                    DP1[i] = Math.min(DP1[i+1], DP2[i]) + 1;
                }
            }

            int[] tmp = DP1;
            DP1 = DP2;
            DP2 = tmp;
        }

        return DP2[0];
    }

    public static void main(String[] args) {
        int sol = solve02("aa");

        System.out.print(sol);
    }

}
