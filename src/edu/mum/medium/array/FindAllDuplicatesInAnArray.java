package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hungduong on 1/12/17.
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 */
public class FindAllDuplicatesInAnArray {

    //Solution 1: O(n) and O(n) space => Bad
    public static List<Integer> findDuplicates01(int[] nums) {
        if(nums == null || nums.length <= 1)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            if(!set.add(num))
                list.add(num);
        }

        return list;
    }

    //Solution 2: O(n) and O(1) space
    //Eg. 4, 3, 2, 7, 8, 2, 3, 1
    //i=0         -7
    //i=1      -2
    //i=2   -3
    //i=3                  -3
    //i=4                     -1
    //i=5  add(3)
    //i=6     add(2)
    public static List<Integer> findDuplicates02(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums == null || nums.length <= 1)
            return list;

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                list.add(Math.abs(nums[i]));
            else
                nums[index] = -nums[index];
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicates02(nums);

        for(Integer num : list)
            System.out.println(num);
    }
}
