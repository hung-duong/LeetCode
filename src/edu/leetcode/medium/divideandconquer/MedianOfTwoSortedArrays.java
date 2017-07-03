package edu.leetcode.medium.divideandconquer;

/**
 * Created by hungduong on 1/7/17.
 */
public class MedianOfTwoSortedArrays {
    //O(m + n) and O(m + n ) space
    public static double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m + n];

        int i = 0, j = 0, k = 0;
        while(i < m || j < n) {
            if(i < m && j < n) {
                nums[k] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if(i < m) {
                nums[k] = nums1[i++];
            } else {
                nums[k] = nums2[j++];
            }

            k++;
        }

        double median;

        if(nums.length % 2 == 1) {
            median = nums[nums.length / 2];
        } else {
            median = (double)(nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        }

        return median;
    }

    //Divide and conquer ==>> Time Limit Exceeded
    public static double findMedianSortedArrays02(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length + 1) >> 1;
        int r = (nums1.length + nums2.length + 2) >> 1;

        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public static int getKth(int[] A, int startA, int[] B, int startB, int k) {
        if(startA > A.length - 1) return B[startB + k - 1];
        if(startB > B.length - 1) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);

        int midA = Integer.MAX_VALUE, midB = Integer.MAX_VALUE;
        if(startA + k/2 - 1 < A.length) {
            midA = A[startA + k/2 - 1];
        }

        if(startB + k/2 - 1 < B.length) {
            midB = B[startB + k/2 - 1];
        }

        if(midA < midB) {
            return getKth(A, startA + k/2, B, startB, k - k/2);
        } else {
            return getKth(A, startA, B, startB + k/2, k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.print(findMedianSortedArrays02(nums1, nums2));
    }

}
