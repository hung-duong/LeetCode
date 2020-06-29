package edu.leetcode.easy.array;

public class TwoSumII {
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/solution/
    //
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;

        while(lo < hi) {
            int sum = numbers[lo] + numbers[hi];

            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[]{lo + 1, hi + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
