/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hungduong
 */
public class TwoSum {

    // Brute force: O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[j] == target - nums[j]) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    // Running time: O(n)
    // Space: O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int index = 0; index < nums.length; index++) {
            if(map.containsKey(target - nums[index])){
                return new int[]{map.get(target - nums[index]), index};
            }
            
            map.put(nums[index], index);
        }
        
        return new int[]{0, 0};
    }


}


