package edu.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungduong on 1/10/17.
 */
public class ContainsDuplicate {

    //Solution 1: Brute force => Time exceed with O(n*(n+1)/2)
    public boolean containsDuplicate01(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }

    //Solution 2: Sorted array => O(nlogn)
    public boolean containsDuplicate02(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1])
                return true;
        }

        return false;
    }

    //Solution 3: Use HashSet with running time O(n) and O(n) space
    public boolean containsDuplicate03(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        // Why we use HashSet. Because add operation in HashSet take O(1) and return true if added AND return false if already exist
        // In List use the add operation with O(n) running time
        // In TreeSet also use the add operation with O(1) running time and return true if added
        Set<Integer> set = new HashSet<>();

        for(Integer num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }

        return false;
    }


    /*
     * Solution 5: Use a big lookup table k. The value in each element in table is to determine whether the index value has appeared
     * before. It uses 8 bits of each element to indicate the existence of 8 numbers.
     *  - For number A, assume k1 = A/8, k2 = A%8 + 1. It uses k1 as the index for lookup table to get element. And then
     * the k2-th bit of the element is checked to find out whether A appeared before.
     *  - If the bit is 1 return true. Or the bit is 0, set the bit to 1 (add A to table lookup).
     * Eg. Now we get the number 0x800( k1 = 0x100 and k2 = 1). Then we get the 0x100-th byte in the table (table[0x100] = 0b10000111)
     * The 1st bit is 1. So we know 0x800 appeared before. Moreover, 0b10000111 means 0x800, 0x801, 0x802 and 0x807 has appeared before.
     */
    public boolean containsDuplicate05(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int size = Integer.MAX_VALUE;
        byte[] tableLookupPOS = new byte[size/8 + 1];
        byte[] tableLookupNEG = new byte[size/8 + 1];

        boolean flag = false;
        int k1 = 0, k2 = 0, check = 0;
        for(Integer num : nums) {
            if(num >= 0) {
                k1 = num/8;
                k2 = num%8;
                check = 1 << k2;

                if((tableLookupPOS[k1] & check) != 0) {
                    return true;
                }

                tableLookupPOS[k1] |= check;
            } else {
                if(num == Integer.MIN_VALUE && !flag) {
                    flag =  true;
                } else if(num == Integer.MIN_VALUE) {
                    return true;
                } else {
                    num = Math.abs(num);
                    k1 = num / 8;
                    k2 = num % 8;
                    check = 1 << k2;

                    if((tableLookupNEG[k1] & check) != 0) {
                        return true;
                    }

                    tableLookupNEG[k1] |= check;
                }
            }

        }

        return false;
    }
}
