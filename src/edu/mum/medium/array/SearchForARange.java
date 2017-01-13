/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.array;

/**
 *
 * @author hungduong
 */
public class SearchForARange {
     public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if(nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                lo = mid;
                while(lo > 0 && nums[lo - 1] == target) {
                    lo--;
                }
                
                hi = mid;
                while(hi < nums.length - 1 && nums[hi + 1] == target) {
                    hi++;
                }
                
                return  new int[]{lo, hi};
            }
        }
        
        return new int[]{-1, -1};
    }
}
