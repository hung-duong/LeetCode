package edu.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    // Solution: Sorting
    // We dont want to know exactly which subarray will be removed...just want to know minimum subarray should be removed.
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] prev = intervals[0];
        int count = 0;

        for(int i=1; i <intervals.length; i++) {
            int[] curr = intervals[i];

            // Case 1: [1 2] [2 3]
            // - We dont remove any internal
            // - Continue add new interval and move prev pointer to new interval
            // - Count to remove interview will not change
            if (prev[1] <= curr[0]) {
                prev = curr;
                continue;
            } else if (prev[0] <= curr[0] && curr[1] <= prev[1]) {
                // Case 2: [1 4] [2 3]  OR [1 3] [2 3]
                // - Remove interval with later end pointer
                // - Prev pointer should point to current interval
                // - Count to remove interview will increase by 1
                prev = curr;
                count++;
            } else if (prev[1] > curr[0] ) {
                // Case 3: [1 3] [2 4]
                // - Remove interval with later end pointer
                // - Prev pointer remains unchanged
                // - Count to remove interview will increase by 1
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // int[][] nums = new int[][]{{81,97},{-71,60},{36,97},{76,96},{59,68},{54,88},{-65,40},{83,84},{27,50},{-59,-50},{73,78},{50,57},{-49,81},{-16,90},{-83,-23},{-58,98},{78,99},{-57,81},{-2,85},{-88,45},{85,90},{-64,17},{76,78},{-17,5},{-98,15},{86,100}};
        int[][] nums = new int[][]{{1,2},{2,3},{3,4},{4,5}};

        System.out.print(eraseOverlapIntervals(nums));
    }
}
