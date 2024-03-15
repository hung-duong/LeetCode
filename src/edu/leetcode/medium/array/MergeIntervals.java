package edu.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ansArrList = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            };
        });

        for (int i=0; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (ansArrList.size() == 0) {
                ansArrList.add(curr);
            } else {
                int top = ansArrList.size() - 1;
                int[] prev = ansArrList.get(top);
                if (prev[1] >= curr[0]) {
                    // Conflict
                    prev[1] = Math.max(prev[1], curr[1]);
                    ansArrList.remove(top);
                    ansArrList.add(prev);
                } else {
                    ansArrList.add(curr);
                }
            }
        }

        int[][] ans = new int[ansArrList.size()][2];
        for (int i=0; i<ansArrList.size(); i++) {
            ans[i] = ansArrList.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        System.out.print(merge(nums));
    }
}
