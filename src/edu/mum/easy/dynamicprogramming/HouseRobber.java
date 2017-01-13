package edu.mum.easy.dynamicprogramming;

/**
 * Created by hungduong on 1/2/17.
 */
public class HouseRobber {
    /*
     *Input: 3, 10, 6, 5, 7, 8, 1, 2
     *Output: 3, 10, 10, 15, 17,23, 23, 25
     */
    public static int rob(int[] nums) {
        if(nums.length == 0)
            return 0;

        int maxAmount = nums[0];
        int presHouse = 0;
        for(int h = 1; h < nums.length; h++) {
            int tmp = nums[h] + presHouse;
            if(maxAmount < tmp) {
                maxAmount = tmp;
            }

            nums[h] = maxAmount;
            presHouse = nums[h - 1];
        }

        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};

        System.out.print(rob(nums));
    }
}
