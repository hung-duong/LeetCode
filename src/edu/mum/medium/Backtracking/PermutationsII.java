package edu.mum.medium.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungduong on 1/24/17.
 */
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

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
                if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;

                permutation.add(nums[i]);
                visited[i] = true;

                permuteHelper(nums, visited, permutation, result);

                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        List<List<Integer>> result = permuteUnique(nums);

        for (List<Integer> ls : result) {
            System.out.println(ls);
        }
    }
}
