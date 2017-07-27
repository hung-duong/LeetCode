package edu.leetcode.medium.array;

/**
 * Created by hungduong on 7/25/17.
 */
public class MaximumLengthOfPairChain {
    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
     */
    public static int findLongestChain(int[][] pairs) {
        int max = 0, len = 0;
        for (int i = 1; i < pairs.length; i++) {
            int[] curr = pairs[i];
            int[] prev = pairs[i - 1];
            if (curr[0] >= prev[1]) {
                len++;

                if (max < len) {
                    max = len;
                }
            } else {
                len = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] paris = {{1,2}, {2,3}, {3,4}};

        int len = findLongestChain(paris);
        System.out.print(len);
    }
}
