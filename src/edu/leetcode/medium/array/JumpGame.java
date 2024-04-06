package edu.leetcode.medium.array;

/**
 * Created by hungduong on 10/21/16.
 */
public class JumpGame {
    public static boolean canJump1(int[] nums) {
        if(nums.length == 0) {
            return false;
        } else if(nums.length == 1) {
            return true;
        }

        int pos = 0;
        int jum = 1;

        while (jum > 0 && pos < nums.length) {
            if(jum <= nums[pos] && pos < nums.length - 1) {
                jum = nums[pos];
            } else {
                jum--;
            }

            if(jum == 0 && pos < nums.length - 1)
                return false;

            pos++;
        }

        return pos == nums.length ? true : false;
    }

    //Same idea..but better to understand.
    //Please review again spresheets note for more infor
    public boolean canJump2(int[] nums) {
        int gas = 0;

        for (int n : nums) {
            if (gas < 0) {
                return false;
            } else if (n > gas) {
                gas = n;
            }
            gas--;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2};
        System.out.print(JumpGame.canJump1(arr));
    }
}
