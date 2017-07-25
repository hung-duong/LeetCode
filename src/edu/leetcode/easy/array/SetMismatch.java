package edu.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungduong on 7/24/17.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};

        int[] res = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                res[0] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }
}
