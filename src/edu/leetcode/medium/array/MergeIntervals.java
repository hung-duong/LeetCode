package edu.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge1(int[][] intervals) {
        List<int[]> ansArrList = new ArrayList<>();

        // Sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            };
        });

        for (int i=0; i<intervals.length; i++) {
            int[] curr = intervals[i];

            // If List is empty add element
            if (ansArrList.size() == 0) {
                ansArrList.add(curr);
            } else {
                // If not empty, pick up previous element added 
                int top = ansArrList.size() - 1;
                int[] prev = ansArrList.get(top);

                // check previous with current element
                if (prev[1] >= curr[0]) {
                    // Conflict -> solve conflict
                    prev[1] = Math.max(prev[1], curr[1]);

                    // Remove previous element and update new element already solved conflict
                    ansArrList.remove(top);
                    ansArrList.add(prev);
                } else {
                    // Not conflict, then add current element in List
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

    public static int[][] merge2(int[][] intervals) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < intervals.length; i++) {
			min = Math.min(min, intervals[i][0]);
			max = Math.max(max, intervals[i][0]);
		}
		
		int[] range = new int[max - min + 1];
		for (int i = 0; i < intervals.length; i++) {
			range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]); 
		}
		
		int start = 0, end = 0;
		LinkedList<int[]> result = new LinkedList<>();
		for (int i = 0; i < range.length; i++) {
			if (range[i] == 0) {
				continue;
			}
			if (i <= end) {
				end = Math.max(range[i], end);
			} else {
				result.add(new int[] {start + min, end + min});
				start = i;
				end = range[i];
			}
		}
		result.add(new int[] {start + min, end + min});
		return result.toArray(new int[result.size()][]);
	}

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{2,5},{4,6},{7,8}};

        System.out.print(merge2(nums));
    }
}
