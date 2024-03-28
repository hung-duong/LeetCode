package edu.leetcode.medium.array;

import java.util.Arrays;

public class NextGreaterElementIII {
    // Solution:
    // 
    public static int nextGreaterElements(int n) {
        // convert n to string -> chars
        char[] nums = Integer.toString(n).toCharArray();

        int indx1 = -1;
        for(int i=nums.length - 1; i>0; i--) {
            if (nums[i] > nums[i-1]) {
                indx1 = i - 1;
                break;
            }
        }

        // Not found the right number
        if (indx1 == -1) return -1;

        int indx2 = -1;
        for(int i=nums.length-1; i>=0; i--) {
            if (nums[i] > nums[indx1]) {
                indx2 = i;
                break;
            }
        }

        // Not found the right number
        if (indx2 == -1) return -1;

        char tmp = nums[indx1];
        nums[indx1] = nums[indx2];
        nums[indx2] = tmp;

        Arrays.sort(nums, indx1+1, nums.length);

        long result = Long.parseLong(new String(nums));

        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }

    public static void main(String[] args) {
        int n = 124651;

        System.out.print(nextGreaterElements(n));
    }
}
