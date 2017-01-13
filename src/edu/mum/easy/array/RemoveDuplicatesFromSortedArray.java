package edu.mum.easy.array;

import java.util.Arrays;

/**
 * Created by hungduong on 1/9/17.
 */
public class RemoveDuplicatesFromSortedArray {
    //Solution 1: bad performance O(n^2)
    //Eg. Input : 1, 2, 2, 3, 3, 4, 4, 5, 6  len = 1
    //    Step 1: 1, 2, 3, 3, 3, 4, 4, 5, 6  len = 2
    //    Step 2: 1, 2, 3, 3, 3, 4, 4, 5, 6  len = 3
    //    Step 3: 1, 2, 3, 4, 4, 4, 4, 5, 6  len = 4
    //    Step 4: 1, 2, 3, 4, 5, 5, 5, 5, 6  len = 5
    //    Step 5: 1, 2, 3, 4, 5, 6, 6, 6, 6  len = 6
    public static int removeDuplicates01(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }

        int len = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                int j = i;
                while(j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }

                if(j == nums.length - 2 && nums[j] == nums[j + 1])
                    break;

                while(j > i) {
                    nums[j] = nums[j + 1];
                    j--;
                }
            }

            len++;
        }

        Arrays.stream(nums).forEach(System.out::print);

        return len;
    }

    //Solution 2: Improve
    public static int removeDuplicates02(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return nums.length;
        }

        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                nums[len] = nums[i];
                len++;
            }
        }

        Arrays.stream(nums).forEach(System.out::print);

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 4, 5, 6};

        System.out.print(removeDuplicates02(nums));
    }
}
