/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hungduong
 */
public class ThreeSum {
    List<List<Integer>> lsTreeSum = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        lsTreeSum.clear();
        
        Arrays.sort(nums);
        
        String str = null;
     
        fourTreeHelper(nums, 0, str, 0, nums.length - 1);
        
        return lsTreeSum;
    }
    
    void fourTreeHelper(int[] nums, int target, String str, int lo, int hi) {
        if (str != null && str.split(",").length == 3) {
            String[] arrstr = str.split(",");
            List<Integer> ls = new ArrayList<>();
            
            for (String arrstr1 : arrstr) {
                ls.add(Integer.parseInt(arrstr1));
            }
            
            if(lsTreeSum.contains(ls)) {
                return;
            }
            
            lsTreeSum.add(ls);
            
            return;
        }
        
        if(str == null) {
            while(lo < hi) { 
                str = nums[lo] + "," + nums[hi];
                fourTreeHelper(nums, target, str, lo + 1, hi - 1);
                
                for(int index = lo + 1; index < hi - 1; index++) {
                    if(3 * nums[index] <= target && nums[index] + 2*nums[hi] >= target) {
                        str = nums[index] + "," + nums[hi];
                        fourTreeHelper(nums, target, str, index + 1, hi - 1);
                    }
                }
                
                for(int index = hi - 1; index > lo + 1; index--) {
                    if(3 * nums[lo] <= target && nums[lo] + 2*nums[index] >= target) {
                        str = nums[lo] + "," + nums[index];
                        fourTreeHelper(nums, target, str, lo + 1, index - 1);
                    }
                }
                
                hi--;
                lo++;
            }
        } else {
            String[] arrstr = str.split(",");
            int sum = 0;
            
            if(arrstr.length == 2)
                sum += Integer.parseInt(arrstr[0]) + Integer.parseInt(arrstr[1]);
            else 
                sum += Integer.parseInt(arrstr[0]) + Integer.parseInt(arrstr[2]);
            
            for(int index = lo; index < hi; index++) {
                if(sum + nums[index] + nums[hi] < target) {
                    int tmp = 0;
                    if(arrstr.length == 2) {
                        tmp = Integer.parseInt(arrstr[0]) + nums[index] + Integer.parseInt(arrstr[1]);
                        str = arrstr[0] + "," + nums[index] + "," + arrstr[1];
                    } else {
                        tmp = Integer.parseInt(arrstr[0]) + nums[lo] + nums[hi] + Integer.parseInt(arrstr[2]);
                        str = arrstr[0] + "," + nums[index] + "," + arrstr[3];
                    }
                    
                    if(tmp == target)
                        fourTreeHelper(nums, target, str, lo + 1, hi - 1);
                }
            }
        }
    }
}
