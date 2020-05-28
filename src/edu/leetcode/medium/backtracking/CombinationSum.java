package edu.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 1/17/17.
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    // Use backtracking solution
    // Since the problem is to get all the possible results, not the best or the number of result,
    // thus we don’t need to consider DP(dynamic programming), recursion is needed to handle it.
    // Note:
    //    If there is duplicated, we should remove the duplicated
    //    If there is the negative, should ignore
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            comb.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i], comb, result);
            comb.remove(comb.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 5};
        List<List<Integer>> result = combinationSum(candidates, 7);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
