package edu.leetcode.hard.array;

import java.util.Arrays;

public class Candy {

    // Solution 1: O(n) & O(n) space
    // Using Left and Right array to compute from left to right and right to left
    // Result is max of left and right
    public int candy1(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i = 1; i < len; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : left[i]; 
        }

        for(int i = len - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : right[i]; 
        }

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += Math.max(left[i], right[i]);
        }

        return total;
    }

    // Solution Improved: O(n) and O(n) but use only 1 array
    public int candy2(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];

        Arrays.fill(candies, 1);

        for(int i = 1; i < len; i++) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : candies[i]; 
        }

        for(int i = len - 2; i >= 0; i--) {
            candies[i] = ratings[i] > ratings[i + 1] ? Math.max(candies[i], candies[i + 1] + 1) : candies[i]; 
        }

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += candies[i];
        }

        return total;
    }

    // Solution 2: O(n) and O(1) space
    public int candy3(int[] ratings) {
        
    }

    
}
