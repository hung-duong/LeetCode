package edu.mum.medium.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/24/17.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        boolean[] visited = new boolean[nums.length];

        permuteHelper(nums, visited, new ArrayList<>(), result);

        return result;

    }

    public static void permuteHelper(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> result) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                permutation.add(nums[i]);
                visited[i] = true;

                permuteHelper(nums, visited, permutation, result);

                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
