package edu.leetcode.easy.array;

/**
 * Created by hungduong on 1/6/17.
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {
   /* Note: The majority element is the element that appears more than ⌊ n/2 ⌋ times
    * O(n) and O(1) space
    * Use the Boyer-Moore Algorithm
    * Please refer to link: https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    */
    public static int majorityElement01(int[] nums) {
        //In the first pass, we need 2 values:
        //1. A candidate value, initially set to any value.
        //2. A count, initially set to 0.
        int major = 0;
        int count = 0;

        // For each element in our input list, we first examine the count value. If the count is equal to 0,
        // we set the candidate to the value at the current element. Next, first compare the element's value
        // to the current candidate value. If they are the same, we increment count by 1. If they are different,
        // we decrement count by 1.
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                major = nums[i];
            } 
            
            if(major != nums[i]) {  //count > 0
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
