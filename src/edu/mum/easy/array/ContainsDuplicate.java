package edu.mum.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hungduong on 1/10/17.
 */
public class ContainsDuplicate {

    /*
     * Solution 1: Use HashSet with running time O(n) and O(n) space
     */
    public boolean containsDuplicate01(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        // Use HashSet instead of List would reduce the searching time complexity
        // to O(1) as opposed to a list which would be O(n).
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }

        return false;
    }

    /*
     * Solution 2: Use a big lookup table k. The value in each element in table is to determine whether the index value has appeared
     * before. It uses 8 bits of each element to indicate the existence of 8 numbers.
     *  - For number A, assume k1 = A/8, k2 = A%8 + 1. It uses k1 as the index for lookup table to get element. And then
     * the k2-th bit of the element is checked to find out whether A appeared before.
     *  - If the bit is 1 return true. Or the bit is 0, set the bit to 1 (add A to table lookup).
     * Eg. Now we get the number 0x800( k1 = 0x100 and k2 = 1). Then we get the 0x100-th byte in the table (table[0x100] = 0b10000111)
     * The 1st bit is 1. So we know 0x800 appeared before. Moreover, 0b10000111 means 0x800, 0x801, 0x802 and 0x807 has appeared before.
     */
    public boolean containsDuplicate02(int[] nums) {
        return true;
    }
}
