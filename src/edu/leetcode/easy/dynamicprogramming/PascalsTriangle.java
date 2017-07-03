package edu.leetcode.easy.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/8/17.
 */
public class PascalsTriangle {

    //Use Divide and conquer =>  Time Limit Exceeded => Need to improve
    //Running time: O(n*n) and space O(n*n)
    public static List<List<Integer>> generate01(int numRows) {
        int n = numRows;

        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> ls = new ArrayList<>();
            for(int k = 0; k <= i; k++) {
                ls.add(Combination(i, k));
            }

            lists.add(ls);
        }

        return lists;
    }

    public static int Combination(int n, int k) {
        if(k == 0 || k == n) {
            return 1;
        }

        return Combination(n - 1, k) + Combination(n - 1, k - 1);
    }

    //DP by using O(n*n) space
    public static List<List<Integer>> generate02(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        int n = numRows;
        int[][] C = new int[n][n];

        for(int i = 0; i < n; i++) {
            List<Integer> ls = new ArrayList<>();

            for(int k = 0; k <= i; k++) {
                if(k == 0 || k == i) {
                    C[i][k] = 1;
                } else {
                    C[i][k] = C[i - 1][k] + C[i - 1][k - 1];
                }

                ls.add(C[i][k]);
            }

            list.add(ls);
        }

        return list;
    }

    //Use
    public static void main(String[] args) {
        int n = 0;

        List<List<Integer>> lists = generate02(n);

        for(List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
