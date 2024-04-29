package edu.leetcode.medium.matrix;

/**
 * Created by hungduong on 2/25/17.
 */
public class GameOfLife {
    private int[][] direct = {{-1,-1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    private int die = 2;
    private int live = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;


        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++ ) {
                int countLives = countLivesNeighbors(board, r, c);
                
                //Condition 4: Any dead cell with exactly three live neighbors becomes a live cell
                if (board[r][c] == 0 && countLives == 3) {
                    board[r][c] = live;
                } else if (board[r][c] == 1) {
                    //Condition 2: Any live cell with two or three live neighbors lives on to the next generation
                    if (countLives == 2 || countLives == 3) {
                        continue;
                    } 

                    // Conidtion 1: Any live cell with fewer than two live neighbors dies as if caused by under-population.
                    // And condition 3: Any live cell with more than three live neighbors dies, as if by over-population.
                    if (countLives < 2 || countLives > 3) {
                        board[r][c] = die;
                    }
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++ ) {
                if (board[r][c] == die)
                    board[r][c] = 0;
                
                if (board[r][c] == live)
                    board[r][c] = 1;
            }
        }
    }

    // countLivesNeighbors function used to calculate how many the lives
    // neighbors around square [postX, postY] except itself
    // If board[x][y] == 1 Or board[x][y] == die (2, this cell have orignial value == 1) 
    private int countLivesNeighbors(int[][] board, int posX, int posY) {
        int m = board.length;
        int n = board[0].length;
        int lives = 0;

        for (int[] pair : direct) {
            int x = posX + pair[0];
            int y = posY + pair[1];

            if (x >= 0 && y >= 0 && x < m && y < n) {
                if (board[x][y] == 1 || board[x][y] == die) {
                    lives++;
                }
            }
        }

        return lives;
    }

}
