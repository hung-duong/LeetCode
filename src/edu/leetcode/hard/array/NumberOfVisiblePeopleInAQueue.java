package edu.leetcode.hard.array;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Arrays.fill(ans, 0);

        Stack<Integer> st = new Stack<>();
        
        for (int i=heights.length - 1; i>=0; i--) {
            while(!st.isEmpty()) {
                // Current user can see people on top of stack, 
                ans[i]++;

                // But current user cannot see next of top of stack 
                // if height of current user <= people on top
                if (heights[i] <= st.peek()) {
                    st.push(heights[i]);
                    break;
                } else {
                // if height of current user > people on top, user can see next people
                    st.pop();
                }
            }
            
            if (st.isEmpty()) {
                st.push(heights[i]);
            }  
        }

        return ans;
    }
}
