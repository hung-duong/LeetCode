package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/5/17.
 */
public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return nums.length;

        //Skips all the same numbers from series beginning eg 5, 5, 5, 1
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
            k++;
        }

        //Return 1 if all the same numbers from series beginning eg 5, 5, 5
        if (k == nums.length - 1) {
            return 1;
        }

        int fligflag = nums[k] - nums[k + 1];

        int count = 1;
        for(int i = k + 1; i < nums.length; i++) {
            int sub = nums[i] - nums[i - 1];

            if(fligflag * sub > 0) {
                if(fligflag > 0) {
                    fligflag = Math.max(fligflag, sub);
                } else {
                    fligflag = Math.min(fligflag, sub);
                }
            } else if(fligflag * sub < 0) {
                fligflag = sub;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,3, 3, 2, 5};

        System.out.print(wiggleMaxLength(nums));
    }
}
