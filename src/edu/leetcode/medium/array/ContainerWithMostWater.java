package edu.leetcode.medium.array;

/**
 * Created by hungduong on 10/3/16.
 */
public class ContainerWithMostWater {

    //Brute force: Running time = n*(n-1)/2 => O(n^2)
    public static int maxAreaBruteForce(int[] height) {
        int maxarea = 0;

        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxarea;
    }


    // Better: O(n) with two way approach
    public static int maxAreaBetter(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int min = 0;
        int mostWater = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            min = Math.min(height[left], height[right]);
            int area = (right - left) * min;
            mostWater = Math.max(mostWater, area);

            while(left < right && height[left] <= min) {
                left++;
            } 

            while (left < right && height[right] <= min) {
                right--;
            }
        }

        return mostWater;
    }

    public static void main (String[] args) {
        int[] arr = {1, 2, 1};

        System.out.print(ContainerWithMostWater.maxAreaBetter(arr));
    }
}
