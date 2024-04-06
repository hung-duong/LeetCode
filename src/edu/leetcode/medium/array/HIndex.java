package edu.leetcode.medium.array;

import java.util.*;

public class HIndex {

    // Solution 1: Sorting
    public static int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);

        for(int i = 0; i < len; i++) {
            if (len - i <= citations[i]) {
                return len - i;
            }
        }

        return 0;
    }
    
    // Solution 2: Counting Frequency and Backward Iteration
    // The idea behind it is some bucket sort mechanisms. First, you may ask why bucket sort. 
    // The h-index is defined as the number of papers with reference greater than the number. 
    // So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, 
    // then for any paper with reference corresponding to the index of the bucket, we increment the count for that bucket. 
    // The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.

    // Then we iterate from the back to the front of the buckets. Whenever the total count exceeds the index of the bucket 
    //  => meaning that we have the index number of papers that have reference greater than or equal to the index. Which will be our h-index result. 
    // The reason to scan from the end of the array is that we are looking for the greatest h-index. 
    public int hIndex2(int[] citations) {
        int len = citations.length;
        int[] arr = new int[len + 1];

        Arrays.fill(arr, 0);

        for (int c : citations) {
            if (c >= len) {
                arr[len]++;
            } else {
                arr[c]++;
            }
        }

        int count = 0;
        for(int i = len; i>=0; i--) {
            count += arr[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 8, 5, 4, 3};
        System.out.print(hIndex(arr));
    }
}
