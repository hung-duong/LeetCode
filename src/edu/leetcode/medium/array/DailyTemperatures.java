package edu.leetcode.medium.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures {
    // https://leetcode.com/problems/daily-temperatures/description/

    // Solution 1: Brute-force, similar to Next Greater Element I
    // Complexity: O(n^2)
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            while(j < temperatures.length && temperatures[i] >= temperatures[j]) {
                j++;
            }

            if (j < temperatures.length) {
                ans[i] = j - i;
            }
        }

        return ans;
    }

    // Solution 2:  Stack to find next day get a warmer temperature 
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        Stack<int[]> st = new Stack<>(); // Pair of temperature and index
        st.push(new int[]{temperatures[temperatures.length - 1], temperatures.length - 1});

        for (int i = temperatures.length - 2; i>=0; i--) {
            if (temperatures[i] < st.peek()[0]) {
                ans[i] = st.peek()[1] - i;
                st.push(new int[]{temperatures[i], i});
                continue;
            }

            while(!st.isEmpty() && temperatures[i] >= st.peek()[0]) {
                st.pop();
            } 

            if (!st.isEmpty()) {
                ans[i] = st.peek()[1] - i;
            } 

            st.push(new int[]{temperatures[i], i});
        }
        

        return ans;
    }
}
