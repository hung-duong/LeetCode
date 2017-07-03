package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/11/17.
 */
public class RotateImage {
    /*
     * Eg.  1 2 3        7 2 1      7 4 1
     *      4 5 6    =>  4 5 6  =>  8 5 2
     *      7 8 9        9 8 3      9 6 3
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0; i < len / 2; i++) {       //For rows
            for(int j = i; j < len - i - 1; j++) {    //For columns
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Anti-rotate
     * Eg.  1 2 3    Rotate 90   3 6 9
     *      4 5 6     ====>      2 5 8
     *      7 8 9                1 4 7
     */
    public static void anti_rotate(int[][] matrix) {
        int len = matrix.length;

        for(int i = 0; i < len / 2; i++) {
            for(int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[len - j - 1][i];
                matrix[len - j- 1][i] = temp;
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3} ,{3,4,5} , {4,5, 6}};

        anti_rotate(matrix);
    }
}
