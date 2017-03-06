package edu.mum.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/25/17.
 */
public class Combinations {
    //Use backtracking
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combineHelper(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    public static void combineHelper(int n, int k, int i, List<Integer> list, List<List<Integer>> result) {
        if(k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int j = i; j <= n; j++) {
            list.add(j);
            combineHelper(n, k - 1, j + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
