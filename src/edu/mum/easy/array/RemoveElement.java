package edu.mum.easy.array;

import java.util.Arrays;

/**
 * Created by hungduong on 1/9/17.
 */
public class RemoveElement {
    /*
     * Given input array nums = [3,2,2,3], val = 3
     * Function should return length = 2, with the first two elements of nums being 2.
     */
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length - 1;
        for(int i = 0; i <= len; i++) {
            while (nums[i] == val && i <= len) {
                nums[i] = nums[len];
                len--;
            }
        }

        Arrays.stream(nums).forEach(System.out::print);

        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 2, 2};

        System.out.print(removeElement(nums, 3));
    }
}
