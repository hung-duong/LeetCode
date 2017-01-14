package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 1/14/17.
 */
public class Subsets {
    //Use backtracking
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        subsetsBacktrack(nums, 0, results, new ArrayList<>());

        return results;
    }

    public static void subsetsBacktrack(int[] nums, int start, List<List<Integer>> results, List<Integer> list) {
        results.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsBacktrack(nums, i + 1, results, list);

            //Remove the element just added above
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> results = subsets(nums);

        for(List<Integer> ls : results)
            System.out.println(ls);
    }
}
