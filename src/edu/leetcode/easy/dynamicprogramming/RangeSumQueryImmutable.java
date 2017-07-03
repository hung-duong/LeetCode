package edu.leetcode.easy.dynamicprogramming;

/**
 * Created by hungduong on 1/1/17.
 */
public class RangeSumQueryImmutable {
    public class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            if(n == 0)
                return;

            for(int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }

            this.sums = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return sums[j];

            return sums[j] - sums[i - 1];
        }
    }
}
