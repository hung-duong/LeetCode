package edu.leetcode.medium.array;

import java.util.Stack;

public class MaximumSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> st = new Stack<>();
        // Find the left bound: index of the fatherest elements greater than or equal to nums[i] in the left -> consider nums[i] is minimum number
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            if(!st.isEmpty()) {
                left[i] = st.peek() + 1; // 
            } else {
                left[i] = 0; // Mean that all the left elements is >= nums[i] and satifis nums[i] is minimum
            }
            st.add(i); //Push i in stack
        }

        st = new Stack<>(); // Empty all elements
        // Find the right bound: index of the fatherest elements greater than or equal to nums[i] in the right -> consider nums[i] is minimum number
        for (int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            if(!st.isEmpty()) {
                right[i] = st.peek() - 1; // 
            } else {
                right[i] = n - 1; // Mean that all the left elements is >= nums[i] and satifis nums[i] is minimum
            }
            st.add(i); //Push i in stack
        }

        long[] prefixSum = new long[n+1];
        for(int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        long maxProduct = 0;
        for(int i=0; i<n; i++) {
            maxProduct = Math.max(maxProduct, nums[i] * sum(prefixSum, left[i], right[i]));
        }

        return (int) (maxProduct % 1000_000_007);

    }

    private long sum(long[] prefixSum, int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
