package edu.leetcode.hard.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    // Solution 1: Brute force 
    // Check every sliding window and comptute the maximum value
    // O(n*k) and O(1) space
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;

        if (len == 0 || k == 0)
            return new int[0];

        int numOfWindow = len - k + 1;
        int[] ans = new int[numOfWindow];

        for (int start = 0; start < numOfWindow; start++) {
            int end = start + k - 1;
            int max = nums[start];
            for (int i = start + 1; i <= end; i++) {
                max = Math.max(max, nums[i]);
            }

            ans[start] = max;
        }
        
        return ans;
    }
    
    // Solution 2: Using PriorityQueue (Max-Heap) to get max on top with O(1)
    // Complexity is depended on PriorityQueue implemeneted by Linked List, Binary Heap or Binary Search Treee
    // But the best is O(nlogk)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;

        if (len == 0 || k == 0)
            return new int[0];

        int numOfWindow = len - k + 1;
        int[] ans = new int[numOfWindow]; // Numbers of windows

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (nums[i2] - nums[i1]));  // Store value

        for (int i=0; i<len; i++) {
            int start = i - k;

            // Remove if Window length >= k to add new ele next step
            if(start >= 0) {
                pq.remove(start);
            }

            // Add new element in Heap
            pq.offer(i);

            if(pq.size() == k) {
                ans[i-k+1] = nums[pq.peek()];
            } 
        }

        return ans;
    }

    // Solution 3: Deque
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices
        
        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            
            // add nums[i]
            win.offerLast(i);

            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow3(nums, 3);
    }
}
