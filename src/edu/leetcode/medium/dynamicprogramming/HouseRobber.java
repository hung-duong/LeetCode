package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/2/17.
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {
    /*
     *Input: 3, 10, 6, 5,  7,  8,  1,   2
     *rob:   3, 10, 9, 15, 17, 23, 18,  25
     *noRob: 0  3, 10, 10, 15, 17, 23,  23
     */
    public static int rob(int[] nums) {
        int rob = 0;
        int noRob = 0;

        for (int h : nums) {
            int newRob = noRob + h;
            int newNoRob = Math.max(rob, noRob);
            rob = newRob;
            noRob = newNoRob;
        }

        return Math.max(rob, noRob);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};

        System.out.print(rob(nums));
    }
}
