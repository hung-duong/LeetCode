package edu.leetcode.medium.array;

public class RemoveDuplicatesFromSortedArrayII {

    /*
    * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
    * Given nums = [1,1,1,2,2,3],
    * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    * */
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }

        int len = 1;
        int repeat = 1;
        int curent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curent) {
                repeat++;
                if (repeat > 2) {
                    continue;
                }
            } else {
                repeat = 1;
                curent = nums[i];
            }

            nums[len] = curent;
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        System.out.print(removeDuplicates(nums));
    }
}
