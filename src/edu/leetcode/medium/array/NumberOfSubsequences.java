package edu.leetcode.medium.array;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
public class NumberOfSubsequences {

    private static int MOD = 1000000007;

    // O(nlogn)
    public int numSubseq1(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        long count = 0;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + pow(2, right - left)) % MOD;
                left++;
            }
        }

        return (int) count;
    }

    public long pow(long x, long y) {
        long ans = 1; // 2

        for (; y > 0; y /= 2) { // 1
            if (y % 2 == 1) ans = (ans * x) % MOD;
            x = (x * x) % MOD;
        }

        return ans;
    }

    // O(n)
    public int numSubseq2(int[] nums, int target) {
        return 1;
    }
}
