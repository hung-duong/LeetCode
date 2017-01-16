package edu.mum.medium.array;

/**
 * Created by hungduong on 1/15/17.
 */
public class WordSearch {
    //Use the Brute-force algorithm
    //I learn the bit mask for every cell visited used to save the memory
    //The running time is O(m*n*4^k) (k is length of word) since we are recursively
    //traversing the 4 adjacent cells at each step and space O(1)
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == "")
            return false;

        int rows = board.length;
        int cols = board[0].length;
        char[] chars = word.toCharArray();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(existHelper(board, row, col, chars, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean existHelper (char[][] board, int i, int j, char[] chars, int pos){
        //If the pos is equal length chars array, the string exist in matrix and return true
        if(pos == chars.length) return true;

        //If the current position (i, j) is over the matrix, then return false
        //If current position is not over the matrix, check the letter in cell (i, j) and letter at pos
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != chars[pos]) return false;

        //Here we used bit mask for every cell visited
        board[i][j] ^= 256;

        //If the letter in cell(i, j) is equal to letter at pos in array, continue find the the neighbor
        //matrix for next pos in array until end array
        boolean result = existHelper(board, i - 1, j, chars, pos + 1)
                || existHelper(board, i + 1, j, chars, pos + 1)
                || existHelper(board, i, j - 1, chars, pos + 1)
                || existHelper(board, i, j + 1, chars, pos + 1);

        //Return back to previous letter
        board[i][j] ^= 256;

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
                        };

        String word = "ABCB";

        if(exist(board, word))
            System.out.print("Word exists");
        else
            System.out.print("Word doesn't exist");
    }
}
