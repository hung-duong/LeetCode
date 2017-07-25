package edu.leetcode.medium.array;

/**
 * Created by hungduong on 7/24/17.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int xor = 0;
        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i - 1] ^ i;
        }

        return xor ^ nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 3, 4, 6};
        int num = findDuplicate(nums);
        System.out.print(num);
    }
}
