package edu.leetcode.medium.array;

import java.util.Stack;

public class NextGreaterElementII {
    // Solution 1: Brute force O(n^2) same Next Greater Element I
    // But in this problems, we need to find next greater element in same circle array
    // Go through elements in arrays from right to left, at a position i in array, we divide 2 parts:
    //  - Elements after of element i should be [i+1, nums.length -1] -> if found, dont need to search in elements before of element i
    //  - Elements before of element i should be [0, i - 1]
    // 
    public static int[] nextGreaterElements1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.MIN_VALUE;
        }

        for (int i = nums.length - 1; i>=0; i--) {
            // Check in first part i+1 -> nums.length -1
            for (int j = i + 1; j < nums.length && ans[i] == Integer.MIN_VALUE; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                }
            }

            // Check in second part 0 -> i - 1
            for (int j = 0; j < i && ans[i] == Integer.MIN_VALUE; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] == Integer.MIN_VALUE ? -1 : ans[i];
        }

        return ans;
    }


    // Solution 2: O(n) + mono-stack
    // nums = [3, 8, 4, 1, 2]
    // First round: ans = [8, -1, -1, 2, -1], stack remaining have [8, 3]
    // Second round: ans = [8, -1, 8, 2, 3]
    public static int[] nextGreaterElements2(int[] nums) {
        int[] ans = new int[nums.length];

        Stack<Integer> st = new Stack<>();

        // First traversing
        for (int i=nums.length - 1; i>=0; i--) {
            while(!st.isEmpty() && nums[i] >= st.peek())
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        // Second traversing
        for (int i=nums.length - 1; i>=0; i--) {
            while(!st.isEmpty() && nums[i] >= st.peek())
                st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        return ans;
    }

    // Solution 3: O(n) without stack
}
