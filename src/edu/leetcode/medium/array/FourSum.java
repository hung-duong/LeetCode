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

    //Solution 2: Basic idea is using subfunctions for 3sum and 2sum, and keeping throwing all impossible cases.
    //            O(n^3) time complexity, O(1) extra space complexity.
    public List<List<Integer>> fourSum02(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        int len = nums.length;
        if(nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if(4*nums[0] > target || 4*max < target)
            return res;

        int i, z;
        for(i = 0; i < len; i++) {
            z = nums[i];
            if(i > 0 && z == nums[i-1])  //Avoid duplication in sorted array
                continue;
            if(z + 3 * max < target)     //z is too small
                continue;
            if(4 * z == target) {        //z is the boundary
                if(i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z,z,z,z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int z1) {
        if(low + 1 >= high) return;

        int max = nums[high];
        if(3 * nums[low] > target || 3 * max < target) {
            return;
        }

        int i, z;
        for(i = 0; i < high - 1; i++) {
            z = nums[i];
            if(i > low && z == nums[i-1])  //Avoid duplication in sorted array
                continue;
            if(z + 2 * max < target)     //z is too small
                continue;
            if(3 * z > target)           //z is too large
                continue;

            if(3 * z == target) {        //z is the boundary
                if(i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }
    }

    /*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList, int z1, int z2) {
        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }

    public static void main (String[] args) {
        FourSum fs = new FourSum();
        int[] ns = {-9,-6,-3,-5,-10,-6,1,-7,7,-1,-3,-10,5,-3,-8,-8,4,0,-7};
        List<List<Integer>> ls = fs.fourSum02(ns, -15);

        for(List<Integer> ss : ls) {
            List<Integer> lss = (List) ss;
            for(int l : lss) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
