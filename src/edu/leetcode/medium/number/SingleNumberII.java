package edu.leetcode.medium.number;

/**
 * Created by hungduong on 10/16/16.
 */
public class SingleNumberII {
    /*
     * Nums = 3, 3, 6, 3
     *        0011, 0011, 0110, 0011
     * Sum of first bit i = 0 => sum = 0
     * Sum of second bit i = 1 => sum = 1 => singleNum != sum << 1 = 2
     * Sum of third bit i = 2 => sum = 1 => singleNum != sum << 2 = 6
     * => 6 is single number
     */
    public static int singleNumber(int[] nums) {
        int singleNum = 0;

        for(int i = 0; i < 32; i++) {
            int sum = 0;

            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }

            if(sum != 0)
                singleNum |= sum << i;
        }

        return singleNum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 6, 3};
        System.out.print(singleNumber(nums));
    }
}
