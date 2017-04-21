/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hungduong
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
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
