package edu.leetcode.medium.array;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    // Naive Linear Search
    // O(n * min(k, n)). It costs O(\min(k, n))O(min(k,n)) time for each linear search.
    // Note that we do at most nn comparisons in one search even if kk can be larger than nn.
    // O(1) space
    public boolean containsNearbyAlmostDuplicate01(int[] nums, int k, int t) {

        for (int i=0; i < nums.length; i++) {
            for (int j=Math.max(i-k, 0); j<k; j++) {
                if (Math.abs(nums[j] - nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    // Self - Balancing Binary search tree
    // Using TreeSet in Java with O(log(n)) in deletion, insertion and searching
    // Complexity: O(n * log(min(n,k)))
    // Space: O(log(min(n, k)))\
    public boolean containsNearbyAlmostDuplicate02(int[] nums, int k, int t) {
        TreeSet<Long>  set = new TreeSet<>();

        for (int i=0; i<nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t) {
                return true;
            }

            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }

            set.add((long) nums[i]);
            if(set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

}
