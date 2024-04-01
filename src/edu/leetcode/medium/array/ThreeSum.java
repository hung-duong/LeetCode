/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hungduong
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        // We don't consider the positive at first time because they cannot make sum of 3 x,y,z -> 0
        for(int i=0; i<nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumII(nums, i, results);
            }
        }

        return results;
    }
    
    void twoSumII(int[] nums, int i, List<List<Integer>> results) {
        int lo = i + 1, hi = nums.length - 1;

        while(lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];

            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo-1])) {
                lo++;
            } else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else {
                results.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            }
        }
    }

    // Same above
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 1 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum == 0) {
                        results.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        // Skip duplicate elements for lo
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        } 

                        // Skip duplicate elements for hi
                         while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        } 
                    }
                    if (sum < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }

        return  results;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.print(threeSum2(nums));
    }

}
