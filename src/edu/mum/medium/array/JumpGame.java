package edu.mum.medium.array;

/**
 * Created by hungduong on 10/21/16.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
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

    public static void main(String[] args) {
        int[] arr = {0, 2};
        System.out.print(JumpGame.canJump(arr));
    }
}
