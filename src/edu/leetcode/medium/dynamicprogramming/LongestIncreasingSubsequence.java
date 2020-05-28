package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 7/26/17.
 */
public class LongestIncreasingSubsequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     * Solution 1: DP => O(n^2)
     */
    public static int lengthOfLIS01(int[] nums) {

        // when input is decreasing like : 3, 2, 1 => Longest Increasing Subsequences is 1 means {3}, {2}, {1}
        // Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i]
        // is the last element of the LIS.
        int[] L = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            L[i] = 1;
        }

        // L(i) = 1 + max(L(j)) where 0 < j < i and arr[j] < arr[i]
        // L(i) = 1, if no such j exists
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i] && L[i] < L[j] + 1) {
                    L[i] = L[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < L[i]) {
                max = L[i];
            }
        }

        return max;
    }

    /**
     * Solution 2: O(nlogn)
     * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
     * https://www.youtube.com/watch?v=S9oUiVYEq7E
     */
    public static int findPosition(int[] A, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    public static int lengthOfLIS02(int[] nums) {
        int[] A = new int[nums.length];
        A[0] = nums[0];

        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= A[0]) {
                // new smallest value
                A[0] = nums[i];
            } else if (nums[i] == A[len - 1]) {
                // A[i] wants to extend largest subsequence
                A[len - 1] = nums[i];
            } else if (nums[i] > A[len - 1]) {
                // A[i] wants to extend largest subsequence
                A[len] = nums[i];
                len++;
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in A
                int index = findPosition(A, 0, len - 1, nums[i]);
                A[index] = A[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        int len = lengthOfLIS02(nums);
        System.out.print(len);
    }
}
