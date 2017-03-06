package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 3/2/17.
 * https://shanzi.gitbooks.io/algorithm-notes/content/problem_solutions/cheapest_palindrome.html
 */
public class CheapestPalindrome {
    public static int solve(String str) {
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

    public static void main(String[] args) {
        int sol = solve("anuja");

        System.out.print(sol);
    }

}
