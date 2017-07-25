package edu.common.test;

/**
 * Created by hungduong on 7/14/17.
 */
public class narvar {

    public static void merge01(int[] nums1, int[] nums2) {
        //Merge the nums2 -> nums1
        int len1 = nums1.length - 1, len2 = nums2.length - 1;

        while (len2 >= 0) {
            nums1[len1] = nums2[len2];
            len1--;
            len2--;
        }

        //Sort the nums1: O(n*n)
        for (int i = 1; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]) {
                    int tmp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = tmp;
                }
            }
        }

        for (int i = 0; i < nums1.length; i++)
            System.out.print(nums1[i]);

    }


    public static void main(String[] args) {
        int[] nums1 = {1, 5, 3, 2, 4, 0, 0, 0, 0, 0};
        int[] nums2 = {6, 7, 8, 9, 10};

        merge01(nums1, nums2);

        //for (int i = 0; i < nums1.length; i++)
        //System.out.print(nums1[i]);
    }
}
