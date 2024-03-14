package edu.leetcode.easy.array;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */

public class ProductOfArrayExceptSelf {
    // Note: Don't use division
    // Use left and right product list
    public int[] productExceptSelf01(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 1; i < nums.length; i++) {
            result[i] = left[i] + right[i];
        }

        return result;
    }

    // O(n) running time and O(n) space
    public int[] productExceptSelf02(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * r;
            r = r * nums[i];
        }

        return result;
    }
}
