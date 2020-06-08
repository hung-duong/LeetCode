package edu.leetcode.medium.array;

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

    // Buckets
    //

}
