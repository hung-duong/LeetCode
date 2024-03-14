package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/9/17.
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
