package edu.mum.medium.backtracking;

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

    //Not use backtracking

    /**
     * Based on the binary: nums = {1, 2, 3} => 2^3 = 8
     * => 000, 001, 010, 011, 100, 101, 110, 111
     * => [], [1], [1, 2], [3], [1, 3],[2, 3], [1,2,3]
     */
    public static List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        int max = 1 << nums.length;
        for(int i = 0; i < max; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            int k = i;
            int index = 0;
            while(k > 0) {
                if((k & 1) > 0) {
                    subset.add(nums[index]);
                }

                k >>= 1;
                index++;
            }
            results.add(subset);
        }
        return results;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> results = subsetsII(nums);

        for(List<Integer> ls : results)
            System.out.println(ls);
    }
}
