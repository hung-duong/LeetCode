package edu.mum.medium.dynamicprogramming;

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
     */
    public int combinationSum4(int[] nums, int target) {
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
}
