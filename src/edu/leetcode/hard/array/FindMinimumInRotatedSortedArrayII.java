package edu.leetcode.hard.array;

public class FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 1};

        System.out.print(findMin(A));
    }
}
