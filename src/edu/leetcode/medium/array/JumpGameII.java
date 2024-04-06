package edu.leetcode.medium.array;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) 
            return 0;

        int prev = 0, jump = 0, max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == prev) {
                jump++;
                prev = max;
            }
        }

        return jump;
    }
}
