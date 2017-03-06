package edu.mum.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 1/24/17.
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);

        combinationSumHelper(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    public static void combinationSumHelper(int[] candidates, int begin, int target, List<Integer> comb, List<List<Integer>>  result) {
        if(target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int i = begin; i < candidates.length && target >= candidates[i]; i++) {
            if(i == begin || candidates[i] != candidates[i - 1]) {
                comb.add(candidates[i]);
                combinationSumHelper(candidates, i + 1, target - candidates[i], comb, result);
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(candidates, 8);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
