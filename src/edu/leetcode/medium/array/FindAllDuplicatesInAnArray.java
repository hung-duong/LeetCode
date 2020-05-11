package edu.leetcode.medium.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by hungduong on 1/12/17.
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 */
public class FindAllDuplicatesInAnArray {

    //Brute force: O(n*(n-1)/2)
    public static List<Integer> findDuplicates01(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    list.add(nums[i]);
                }
            }
        }

        return list;
    }

    //Sorting: O(n*log(n))
    public static List<Integer> findDuplicates02(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1])
                list.add(nums[i]);
        }

        return list;
    }

    //Better: O(n) and O(n) space => Bad
    public static List<Integer> findDuplicates03(int[] nums) {
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

    //Good: O(n) and O(1) space
    //Eg. 4, 3, 2, 7, 8, 2, 3, 1
    //i=0         -7
    //i=1      -2
    //i=2   -3
    //i=3                  -3
    //i=4                     -1
    //i=5  add(3)
    //i=6     add(2)
    public static List<Integer> findDuplicates04(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if(nums == null || nums.length <= 1)
            return list;

        for(int i = 0; i < nums.length; i++) {
            int positive = Math.abs(nums[i]);
            if(nums[positive - 1] < 0)
                list.add(positive);
            else
                nums[positive - 1] = -nums[positive - 1];
        }

        return list;
    }

    //Good: O(n) and O(1) space
    public static List<Integer> findDuplicates05(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] temps = new int[n + 1];

        for (int i=0; i<n; i++) {
            temps[nums[i]]++;
        }

        for(int i = 0; i < n + 1; i++) {
            if (temps[i] > 1)
                list.add(i);
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
