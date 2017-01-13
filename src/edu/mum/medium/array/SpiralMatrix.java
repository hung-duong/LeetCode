package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 1/12/17.
 */
public class SpiralMatrix {
    //Solution 1: O(m*n) and O(m*n) space
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(true) {
            for(int col = left; col <= right; col++)
                list.add(matrix[up][col]);

            if(++up > down)
                break;

            for(int row = up; row <= down; row++)
                list.add(matrix[row][right]);

            if(--right < left)
                break;

            for(int col = right; col >= left; col--)
                list.add(matrix[down][col]);

            if(--down < up)
                break;

            for(int row = down; row >= up; row--)
                list.add(matrix[row][left]);

            if(++left > right)
                break;
        }

        for(Integer i : list) {
            System.out.println(i + " ");
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3},
                           {4,5,6},
                           {7,8,9}};

        spiralOrder(matrix);
    }
}
