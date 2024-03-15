package edu.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    // https://leetcode.com/problems/next-greater-element-i/description/
    // The array nums2 containe duplicated elements?

    // Solution 1: Brute force O(n^3)
    // Algo: Each element in nums1, find existing in nums2, if yes, then continue nums2 to find next greater element
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int k = j + 1;
                    while (k < nums2.length && ans[i] == -1) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                        }
                        k++;
                    }
                }
            }
        }

        return ans;
    }

    // Solution 2: Use HashMap to keep track next greater element
    // Complexity: O(n^2)
    // nums1 = {2, 4}, {1, 2, 3, 4}
    // tbale = {
    //            "1" -> "2",
    //            "2" -> "3",
    //            "3" -> "4",
    //        }
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Map<Integer, Integer> hmap = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++) {
            int j = i + 1;
            while(j < nums2.length) {
                if(nums2[j] > nums2[i]) {
                    hmap.put(nums2[i], nums2[j]);
                    break;
                }
                j++;
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hmap.getOrDefault(nums1[i], -1);
        }

        return ans;

    }

    // Solution 3: Using HashMap to keep track next greater element and use Stack to find the next greater element for each element in nums1 within nums2
    // We iterates through nums2 from right -> left and maintain a stack of elements in decreasing order.
    //      For each element in nums2, it finds the next greater element by poping elements from the stack until finding an element greater than the current value.
    //      Need to store mapping each elements to its next greater element in HashMap
    // Finally, need a function to returns an array containing the next greater elements for each elements in nums1
    // Complexity: O(n + m) 
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // HashMap container next greater element 
        Map<Integer, Integer> hmap = new HashMap<>();

        // Stack used to find next greater element in array nums2
        Stack<Integer> st = new Stack<>();

        st.push(nums2[nums2.length - 1]);
        hmap.put(nums2[nums2.length - 1], -1); //Last element in nums2 does not containe Next Greater Element

        for (int i = nums2.length - 2; i>=0; i--) {

            if (nums2[i] < st.peek()) {
                hmap.put(nums2[i], st.peek());
                st.push(nums2[i]);
                continue;
            }

            //Else, we pop all element in stack til nums2[i] > st.peek()
            while(!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }

            // If stack empty then back to case at line 84
            if (st.isEmpty()) {
                hmap.put(nums2[i], -1);
            } else {
                hmap.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        for (int i = 0;  i<nums1.length; i++) {
            ans[i] = hmap.getOrDefault(nums1[i], -1);
        }
    }

    // Solution 4: O(n) without stack, only use HashMap
    public static int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        return null;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        int[] ans = nextGreaterElement2(nums1, nums2);

        for(Integer num : ans)
            System.out.println(num);
    }

}
