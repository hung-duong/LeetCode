package edu.leetcode.medium.string;

import java.util.Arrays;

/**
 * Created by hungduong on 1/8/17.
 */
public class ZigZagConversion {

    // Solution 1: Simulate Zig-Zag Movement
    public static String convert1(String s, int numRows) {
        if(numRows == 0 || numRows == 1 || s.length() <= numRows)
        return s;

        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);

        char[][] matrix = new char[numRows][numCols];

        int indexStr = 0;
        for(int currCol = 0; currCol < numCols; currCol++) {
            for(int currRow = 0; currRow < numRows; currRow++) {
                if(indexStr < n) {
                    if(currCol % 2 == 0 || numRows == 2) {
                        matrix[currRow][currCol] = s.charAt(indexStr);
                        indexStr++;
                    } else if(currRow > 0 && currRow < numRows - 1) {
                        matrix[numRows - currRow - 1][currCol] = s.charAt(indexStr);
                        indexStr++;
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(matrix[i][j] != 0)
                    stringBuilder.append(matrix[i][j]);
            }
        }

        return stringBuilder.toString();
    }

    // Soluton: (Same but more easy to un)Simulate Zig-Zag Movement
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        //Step 1: Init variables
        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);

        // Init matrix and assign ' ' for each cell
        char[][] matrix = new char[numRows][numCols];
        for(char[] row: matrix) {
            Arrays.fill(row, ' ');
        }

        int currRow = 0, currCol = 0;
        int indexStr = 0;

        // Step 2: Iterate each section (zig-zag) of the matrix and fill it with characters from the input strong
        while(indexStr < n) {
            // Iterate from top to botton
            while(currRow < numRows && indexStr < n) {
                matrix[currRow][currCol] = s.charAt(indexStr);
                currRow++;
                indexStr++;
            }

            // Iterate diagnal
            currRow -= 2;
            currCol += 1;
            while(currRow > 0 && currCol < numCols && indexStr < n) {
                matrix[currRow][currCol] = s.charAt(indexStr);
                currRow--;
                currCol++;
                indexStr++;
            }
        }

        // Step 3: Interate the maxtrix row-wise and append charaters (except space) in ans string
        StringBuilder sb = new StringBuilder();
        for(char[] row: matrix) {
            for (char c: row) {
                if (c != ' ') {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    //

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        System.out.print(convert1(s, 4));
    }
}
