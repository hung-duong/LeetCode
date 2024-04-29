package edu.leetcode.hard.matrix;

/**
 * Created by hungduong on 11/2/16.
 */
public class LongestIncreasingPathInAMatrix {

    // Solution 1: DFS + Memoization
    // Complexity: O(m*n): Every cell will be calculated once and only once. 
    //             O(m*n): space

    // Define 4 direction that we can move to up, down, left, right
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Define a tracker matrix used to know longest increasing path at a position[x, y].
        // For example matrix = 9, 9, 4    => tracker = 4, 3, 1  
        //                      6, 6, 8                 3, 2, 1
        //                      2, 1, 1                 2, 1, 1
        // How to calculate the tracker mattrix
        int[][] tracker = new int[rows][columns];

        // For each position [r, c], we will find the longest increasing path and compare with exisiting
        int maxLIP = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int len = dfs(matrix, r, c, tracker);
                maxLIP = Math.max(maxLIP, len);
            }
        }

        return maxLIP;
    }

    public int dfs(int[][] matrix, int posX, int posY, int[][] tracker) {
        // If we found that the tracker[r][c] already computed in the previous time
        // We know the longest increasing path at postion [posX, posY] 
        // We return tracker[posX][posY]
        if (tracker[posX][posY] > 0) 
            return tracker[posX][posY];

        int max = 1;
        for (int[] pair : directions) {
            int newPosX = posX + pair[0];
            int newPosY = posY + pair[1];

            // If the new postion does not satisfied the conditions:
            // 1. New postion should not be out of boundary
            // 2. The value of cell at [newPosX, newPosY] should be less than value of cell at [posX, posY] 
            if (newPosX < 0 || newPosX >= matrix.length ||
                 newPosY < 0 || newPosY >= matrix[0].length ||
                 matrix[posX][posY] <= matrix[newPosX][newPosY])  {
                continue;
            }

            // Find longest increasing path of new postion [newPosX, newPosY]
            // Then compare the max which found from other direction.
            int len = 1 + dfs(matrix, newPosX, newPosY, tracker);
            max = Math.max(max, len);
        }

        // Update to tracker at [posX, posY] the maximal longest increasing value that found from four directions.
        tracker[posX][posY] = max; 

        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
            };

        // System.out.print(longestIncreasingPath(nums));
    }

}
