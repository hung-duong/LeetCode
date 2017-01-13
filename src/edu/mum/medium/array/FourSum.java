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
public class FourSum {
    List<List<Integer>> lsFourSum = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        lsFourSum.clear();
        
        Arrays.sort(nums);
        
        String str = null;
     
        fourSumHelper(nums, target, str, 0, nums.length - 1);
        
        return lsFourSum;
    }
    
    void fourSumHelper(int[] nums, int target, String str, int lo, int hi) {
        if (str != null && str.split(",").length == 4) {
            String[] arrstr = str.split(",");
            List<Integer> ls = new ArrayList<>();
            
            for (String arrstr1 : arrstr) {
                ls.add(Integer.parseInt(arrstr1));
            }
            
            if(lsFourSum.contains(ls)) {
                return;
            }
            
            lsFourSum.add(ls);
            
            return;
        }
        
        if(str == null) {
            while(lo < hi) { 
                str = nums[lo] + "," + nums[hi];
                fourSumHelper(nums, target, str, lo + 1, hi - 1);
                
                for(int index = lo + 1; index < hi - 2; index++) {
                    if(4 * nums[index] <= target && nums[index] + 3*nums[hi] >= target) {
                        str = nums[index] + "," + nums[hi];
                        fourSumHelper(nums, target, str, index + 1, hi - 1);
                    }
                }
                
                for(int index = hi - 1; index > lo + 2; index--) {
                    if(4 * nums[lo] <= target && nums[lo] + 3*nums[index] >= target) {
                        str = nums[lo] + "," + nums[index];
                        fourSumHelper(nums, target, str, lo + 1, index - 1);
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
                sum += Integer.parseInt(arrstr[0]) + Integer.parseInt(arrstr[3]);
            
            while(lo < hi) {
                if(sum + nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    int tmp = 0;
                    if(arrstr.length == 2) {
                        tmp = Integer.parseInt(arrstr[0]) + nums[lo] + nums[hi] + Integer.parseInt(arrstr[1]);
                        str = arrstr[0] + "," + nums[lo] + "," + nums[hi] + "," + arrstr[1];
                    } else {
                        tmp = Integer.parseInt(arrstr[0]) + nums[lo] + nums[hi] + Integer.parseInt(arrstr[3]);
                        str = arrstr[0] + "," + nums[lo] + "," + nums[hi] + "," + arrstr[3];
                    }
                    
                    if(tmp == target)
                        fourSumHelper(nums, target, str, lo + 1, hi - 1);
                    
                    lo++;
                }
            }
        }
    }

    public static void main (String[] args) {
        FourSum fs = new FourSum();
        int[] ns = {-9,-6,-3,-5,-10,-6,1,-7,7,-1,-3,-10,5,-3,-8,-8,4,0,-7};
        List<List<Integer>> ls = fs.fourSum(ns, -15);
        
        for(List<Integer> ss : ls) {
            List<Integer> lss = (List) ss;
            for(int l : lss) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
