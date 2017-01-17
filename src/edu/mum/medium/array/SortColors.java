package edu.mum.medium.array;

/**
 * Created by hungduong on 1/16/17.
 */
public class SortColors {
    public void sortColors01(int[] nums) {
        if(nums.length == 0)
            return;

        int zeros = 0, ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else if (nums[i] == 1) ones++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zeros) nums[i] = 0;
            else if (i < ones + zeros) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    //In place solution
    public void sortColors02(int[] nums) {
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; ++i){
            if (nums[i] == 0 && i != j)
                swap(nums[i--], nums[j++]);
            else if (nums[i] == 2 && i != k)
                swap(nums[i--], nums[k--]);
        }
    }

    public void swap(int i, int j) {
        i ^= j;
        j ^= i;
        i ^= j;
    }
}
