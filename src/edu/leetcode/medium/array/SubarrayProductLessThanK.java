package edu.leetcode.medium.array;

public class SubarrayProductLessThanK {

    // Solution 1: Using expand like in 647. Palindromic Substrings
    // Complextiy O(n^2) and O(1) space
    public static int expand(int[] nums, int pos, int k) {
        int count = 0;
        long product = 1;
        while (pos >=0) {
            product *= nums[pos];
            if (product < k) {
                count++;
            } else {
                break;
            }
            pos--;
        }

        return count;
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int count = 0;
        for (int i=0; i < nums.length; i++) {
            count += expand(nums, i, k);
        }

        return count;
    }

    // Solution 2: Using DP like in 647. Palindromic Substrings -> Memory Limit Exceeded
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length;
        int[][] DP = new int[n][n];

        // If len = 1
        for (int i=0; i < nums.length; i++) {
            DP[i][i] = nums[i];
        }
 
        // If len > 2
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                DP[i][j] = nums[j] * DP[i][j-1] < k ? nums[j] * DP[i][j-1] : k;
            }
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if (DP[i][j]!=0 && DP[i][j] < k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Solution 2: Sliding windows
    public static int numSubarrayProductLessThanK3(int[] nums, int k) {
        int left = 0, prod = 1, count = 0;
        for(int right = 0; right < nums.length; right++) {
            prod = prod * nums[right];
            while(left <= right && prod >= k) {
                prod /= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,6};

        System.out.print(numSubarrayProductLessThanK2(nums, 19));
    }
}
