package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/4/17.
 */
public class CombinationSumIV {
    /*
     *target is the sum of numbers in the array.
     *The # of combinations of target:
     *    comb[target] = sum(comb[target - nums[i]]),
     *    where 0 <= i < nums.length,
     *    and target >= nums[i]
     * nums = {1, 2, 3}, target = 4
     * comb = {1, 0, 0, 0, 0}
     *         1  1  2  4  7
     * nums = {1, 2, 3}
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] comb =  new int[target + 1];
        comb[0] = 1;

        for(int i = 1; i < comb.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }

        return comb[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.print(combinationSum4(nums, target));
    }
}
