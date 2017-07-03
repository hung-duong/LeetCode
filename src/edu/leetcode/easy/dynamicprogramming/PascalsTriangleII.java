package edu.leetcode.easy.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/8/17.
 */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        int[] C = new int[n + 1];
        C[0] = 1;

        List<Integer> ls = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            for(int k = i; k > 0; k--) {
                C[k] = C[k] + C[k - 1];
            }
        }

        for(int i = 0; i <= n; i++) {
            ls.add(C[i]);
        }

        return ls;
    }


    public static void main(String[] args) {
        int n = 4;

        List<Integer> list = getRow(n);

        System.out.println(list);
    }
}
