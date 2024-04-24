package edu.leetcode.easy.matrix;

import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (!checkSubRectangle(board, i, j)) {
                    return false;
                }
            }
        }

        return checkRows(board) && checkColumns(board);
    }

    public boolean checkSubRectangle(char[][] board, int posX, int posY) {
        boolean[] marked = new boolean[10];
        Arrays.fill(marked, false);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i + posX*3][j + posY*3] == '.')
                    continue;
                
                int curr = board[i + posX*3][j + posY*3] - '0';
                if (marked[curr]) 
                    return false;
                marked[curr] = true;
            }
        }

        return true;
    }

    public boolean checkRows(char[][] board) {
        for (int i=0; i<9; i++) {
            boolean[] marked = new boolean[10];
            Arrays.fill(marked, false);

            for (int j=0; j<9; j++) {
                if(board[i][j] == '.')
                    continue;
                
                int curr = board[i][j] - '0';
                if (marked[curr]) 
                    return false;
                marked[curr] = true;
            }
        }

        return true;
    }

    public boolean checkColumns(char[][] board) {
        for (int j=0; j<9; j++) {
            boolean[] marked = new boolean[10];
            Arrays.fill(marked, false);

            for (int i=0; i<9; i++) {
                if(board[i][j] == '.') 
                    continue;
                
                int curr = board[i][j] - '0';
                if (marked[curr]) 
                    return false;
                marked[curr] = true;
            }
        }

        return true;
    }
}
