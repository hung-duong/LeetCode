package edu.leetcode.easy.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungduong on 7/24/17.
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

    //Brute force: O(n^2)
    public static int[] findErrorNumsBruteForce(int[] nums) {
        int dup = -1, missing = -1;

        for(int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=0; j<nums.length; i++) {
                if (nums[j] == i)
                    count++;
            }
            if (count == 2)
                dup = i;
            else if (count == 0)
                missing = i;
            if (dup > 0 && missing > 0)
                break;
        }

        return new int[]{dup, missing};
    }

    //Sorting: O(n(logn))
    public static int[] findErrorNumsSorting(int[] nums) {
        Arrays.sort(nums);

        int dup = -1, missing = -1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }

        return new int[]{dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }

    //Better: O(n)
    public static int[] findErrorNumsBetter(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};

        int dup = -1, missing = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                dup = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{dup, missing};
    }

    //More Better: O(n)
    public static int[] findErrorNumsMoreBetter(int[] nums) {
        int[] a = new int[nums.length + 1];
        for (int i: nums)
            a[i]++;

        int dup = -1, missing = -1;
        for(int i=1; i<a.length; i++) {
            if (a[i] == 0)
                missing = i;
            if (a[i] == 2)
                dup = i;
        }

        return new int[] {dup, missing};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] res = findErrorNumsBetter(nums);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
