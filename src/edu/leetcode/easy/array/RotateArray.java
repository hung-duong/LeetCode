package edu.leetcode.easy.array;

import java.util.Arrays;

/**
 * Created by hungduong on 1/9/17.
 */
public class RotateArray {
    //Solution 1:  On(k*n) In-Place => Time Limit Exceeded => move to solution 2
    public static void rotate01(int[] nums, int k) {

        int n = nums.length - 1;
        while(k > 0) {
            int temp = nums[n];
            for(int i = n; i > 0; i--)
                nums[i] = nums[i - 1];

            nums[0] = temp;
            k--;
        }

        Arrays.stream(nums).forEach(System.out::print);
    }

    //Solution 2: O(n) and O(n) space
    public static void rotate02(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        int[] temps = new int[n];

        int i = 0;
        while (i < n - k) {
            temps[k + i] = nums[i++];
        }

        i = n - k;
        while (i < n) {
            temps[i - n + k] = nums[i++];
        }

        for(i = 0; i < n; i++) {
            nums[i] = temps[i];
        }

        Arrays.stream(nums).forEach(System.out::print);
    }

    //Solution 3: O(n) and O(1) space (Interesting way)
    public static void rotate03(int[] nums, int k) {
        if(nums.length <= 1) {
            return;
        }

        //step each time to move
        int step = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        rotate03(nums, 3);
    }
}
