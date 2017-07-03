package edu.leetcode.easy.string;

/**
 * Created by hungduong on 1/8/17.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows == 0 || numRows == 1 || s.length() <= numRows)
            return s;

        int rows = numRows;
        int columns = 2 * s.length() / (rows - 1); // s.length()/(2*rows) + s.length() / rows + 1

        char[][] matrix = new char[rows][columns];

        int index = 0;
        for(int j = 0; j < columns; j++) {
            for(int i = 0; i < rows; i++) {
                if(index < s.length()) {
                    if(j % 2 == 0 || rows == 2) {
                        matrix[i][j] = s.charAt(index);
                        index++;
                    } else if(i > 0 && i < rows - 1) {
                        matrix[rows - i - 1][j] = s.charAt(index);
                        index++;
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] != 0)
                    stringBuilder.append(matrix[i][j]);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        System.out.print(convert(s, 5));
    }
}
