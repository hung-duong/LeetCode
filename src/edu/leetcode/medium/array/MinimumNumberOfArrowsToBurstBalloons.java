package edu.leetcode.medium.array;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    // Solution 1: Sorting 
    // in contrast to 435. Non-overlapping Intervals, 
    // in this problem, we want to find minimun interections between arrays -> corresponding to number of arrows we need to use.
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p, q) -> Integer.compare(p[1], q[1]));

        int[] prev = points[0];
        int count = 0;
        
        // Find the common part between subarray
        for(int i=1; i <points.length; i++) {
            int[] curr = points[i];

            if (prev[1] < curr[0]) {
                count++;
                prev = curr;
            } else {
                prev[0] = curr[0];
                prev[1] = prev[1] < curr[1] ? prev[1] : curr[1];
            }
        }

        return count + 1;
    }

    // Solution 2: 

    public static void main(String[] args) {
        // int[][] nums = new int[][]{{81,97},{-71,60},{36,97},{76,96},{59,68},{54,88},{-65,40},{83,84},{27,50},{-59,-50},{73,78},{50,57},{-49,81},{-16,90},{-83,-23},{-58,98},{78,99},{-57,81},{-2,85},{-88,45},{85,90},{-64,17},{76,78},{-17,5},{-98,15},{86,100}};
        // int[][] nums = new int[][]{{4,12},{7,8},{7,9},{7,9},{2,8},{6,7},{5,14},{4,13}};
        int[][] nums = new int[][]{{10,16},{2,8},{1,6},{7,12}};

        System.out.print(findMinArrowShots(nums));
    }
}
