package edu.mum.medium.array;

/**
 * Created by hungduong on 1/16/17.
 */
public class MaximumProductSubarray {
    // Loop through the array, each time remember the max and min value for the previous product,
    // the most important thing is to update the max and min value:
    //      we have to compare among max * A[i], min * A[i] as well as A[i],
    //      since this is product, a negative * negative could be positive.
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmpMax = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct*nums[i], minProduct*nums[i]), nums[i]);
            minProduct = Math.min(Math.min(tmpMax*nums[i], minProduct*nums[i]), nums[i]);

            if(maxProduct > result) result = maxProduct;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.print(maxProduct(nums));
    }
}
