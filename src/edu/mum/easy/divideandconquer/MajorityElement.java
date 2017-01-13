package edu.mum.easy.divideandconquer;

/**
 * Created by hungduong on 1/6/17.
 */
public class MajorityElement {
    //O(n) and O(1) space
    public static int majorityElement01(int[] nums) {
        int major = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                count++;
                major = nums[i];
            } else if(major != nums[i]) {  //count > 0
                count--;
            } else {
                count++;
            }
        }

        return major;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 5};

        System.out.print(majorityElement01(nums));
    }
}
