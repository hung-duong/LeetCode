package edu.leetcode.hard.array;

/**
 * Created by hungduong on 7/4/17.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int pos = 0, jum = 1;
        int count = 0;
        while (jum > 0 && pos < nums.length - 1) {
            if(jum <= nums[pos] && pos < nums.length - 1) {
                jum = nums[pos];
                count++;

                if(pos + jum >= nums.length - 1) {
                    return count;
                }
            } else {
                jum--;
            }

            pos++;
        }

        return count;
    }
}
