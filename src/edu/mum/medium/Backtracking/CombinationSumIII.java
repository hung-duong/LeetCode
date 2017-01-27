package edu.mum.medium.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/25/17.
 */
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSumHelper(k, n, 1, new ArrayList<>(), result);

        return result;
    }

    public static void combinationSumHelper(int k, int n, int begin, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == k && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = begin; i <= 9; i++) {
            list.add(i);
            combinationSumHelper(k, n - i, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 7);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
