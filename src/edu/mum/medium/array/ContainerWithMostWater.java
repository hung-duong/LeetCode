package edu.mum.medium.array;

/**
 * Created by hungduong on 10/3/16.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int min = 0;
        int mostWater = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if(min >= height[left]) {
                left++;
            } else if (min >= height[right]){
                right--;
            } else {
                min = height[left] < height[right] ? height[left] : height[right];

                int sum = (right - left) * min;

                if(mostWater < sum)
                    mostWater = sum;
            }
        }

        return mostWater;
    }

    public static void main (String[] args) {
        int[] arr = {1, 2, 1};

        System.out.print(ContainerWithMostWater.maxArea(arr));
    }
}
