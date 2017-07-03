package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/12/17.
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        //Base on the property a^b^b = a
        //Eg. input = 2 1 0 4 5 6 7
        //            0 1 2 3 4 5 6 7
        int xor = 0, pos = 0;
        while(pos < nums.length) {
            xor = xor ^ pos ^ nums[pos];
            pos++;
        }

        return xor ^ pos;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4, 5};

        System.out.print(missingNumber(nums));
    }
}
