package edu.leetcode.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hungduong on 1/10/17.
 */
public class ContainsDuplicateII {
    //Solution 1: Good => 14ms
    public static boolean containsNearbyDuplicate01(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        // Why using Set: A Set contains no duplicate elements. That is one of the major reasons to use a set. 
        // Why using Hashet: HashSet is Implemented using a hash table. Elements are not ordered. 
        //                   The add, remove, and contains methods have constant time complexity O(1).
        // https://www.programcreek.com/2013/03/hashset-vs-treeset-vs-linkedhashset/
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            /*
            * Eg. 7, 3, 1, 0, 5, 4, 9, 10, 5, 2
            *     k = 3
            *     first pos of 5 is 4  (j)
            *     Second pos of 5 is 8 (i)
            *     8 - 3 > 4. So when i achieves to 8, the first 5 ele in set is remove
            *     => i - j > k => false
            *     We move the window k elements alongside of array
            */
            if(i > k)
                set.remove(nums[i - k - 1]);

            if(!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    //Solution 1: Bad => 22ms
    public boolean containsNearbyDuplicate02(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> indices = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]) && i - indices.get(nums[i]) <= k) {
                return true;
            } else {
                indices.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 1, 0, 5, 4, 9, 10, 5, 2};

        System.out.print(containsNearbyDuplicate01(nums, 3));
    }
}
