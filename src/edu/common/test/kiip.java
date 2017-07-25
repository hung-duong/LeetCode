package edu.common.test;

/**
 * Created by hungduong on 7/17/17.
 */
public class kiip {
    /**
     * Write a method that returns the most common subsequence of size n in a string
     * input "dogcatchcat"
     */
    public static int mostCommonSubsequence(String input) {
        if (input == null || input.length() == 0) return 0;

        int[][] mat = new int[input.length() + 1][input.length() + 1];

        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= input.length(); j++) {
                if (input.charAt(i - 1) == input.charAt(j - 1) && i != j) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= input.length(); j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        return mat[input.length()][input.length()];
    }

    public static void main(String[] args) {
        String str = "dogchabccatcat";
        int n = mostCommonSubsequence(str);

        System.out.print(n);
    }
}
