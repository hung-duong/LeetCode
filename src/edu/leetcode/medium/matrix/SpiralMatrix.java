package edu.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/12/17.
 */
public class SpiralMatrix {
    //Solution 1: O(m*n) and O(m*n) space
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(true) {

            //1. Move column [left -> right] at row up
            for(int col = left; col <= right; col++)
                ans.add(matrix[up][col]);

            //Condition: Move row down 1 because square [up, right] already included at 1
            if(++up > down)
                break;

            //2. Move row [up -> down] at column right
            for(int row = up; row <= down; row++)
                ans.add(matrix[row][right]);

            //Condition: Move column left 1 because square [down, right] already included at 2
            if(--right < left)
                break;

            //3. Move column [right -> left] at row down
            for(int col = right; col >= left; col--)
                ans.add(matrix[down][col]);

            //Condition: Move row up 1 because square [down, left] already included at 3
            if(--down < up)
                break;

            //4. Move row [down -> up] at column left
            for(int row = down; row >= up; row--)
                ans.add(matrix[row][left]);

            //Condition: Move column right 1 because spare [up, left] already included at 4
            if(++left > right)
                break;

            // Continue until one of condition 1, 2, 3 or 4 satfities to break
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3},
                           {4,5,6},
                           {7,8,9}};

        spiralOrder(matrix);
    }
}
