package edu.leetcode.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/13/17.
 */
public class MajorityElementII {
    //Note: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times
    //Eg. input = 3,2,1,3,4,3,7,8
    //To solve. Use the Distributed Boyer-Moore algorithm
    // Please refer to link
    // 1. https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    // 2. http://www.cs.rug.nl/~wim/pub/whh348.pdf
    public static List<Integer> majorityElement(int[] nums) {
        /* Distributed Boyer-Moore
         * Because we have to find all elements that appear more than ⌊ n/3 ⌋ times
         * => there at most 2 elements which have more than ⌊ n/3 ⌋ times ( > 2n/3) and the rest should < n/3
         * Similar to Boyer-Moore algorithm
         */

        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;

        int majority1 = nums[0], majority2 = nums[0];
        int count1 = 1, count2 = 1;

        for(int num : nums) {
            if(majority1 == num) {
                count1++;
            } else if(majority2 == num) {
                count2++;
            } else if(count1 == 0) {
                count1 = 1;
                majority1 = num;
            } else if(count2 == 0) {
                count2 = 1;
                majority2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        System.out.println(majority1 + " " + majority2);

        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(majority1 == num) {
                count1++;
            } else if(majority2 == num) {
                count2++;
            }
        }

        if(count1 > nums.length / 3) list.add(majority1);
        if(count2 > nums.length / 3) list.add(majority2);

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {8,8,7,7,7};

        System.out.print(majorityElement(nums));
    }
}
