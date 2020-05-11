package edu.leetcode.medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungduong on 7/24/17.
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindTheDuplicateNumber {

    // O(nlogn) running time
    public static int findDuplicate01(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

    // O(n) running time and O(n) space
    public static int findDuplicate02(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int n:nums) {
            if (set.contains(n))
                return n;
            set.add(n);
        }

        return -1;
    }

    // O(n)
    public static int findDuplicate03(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % len] += len;
        }

        int max = nums[0], result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                result = i;
            }
        }

        return result;
    }

    // FAILED: O(n) BUT failed for case nums = [2,2,2,2,2]
    public static int findDuplicate04(int[] nums) {
        int xor = 0;
        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i - 1] ^ i;
        }

        return xor ^ nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 3, 4, 6};
        int num = findDuplicate01(nums);
        System.out.print(num);
    }
}
