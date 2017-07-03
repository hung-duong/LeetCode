package edu.leetcode.hard.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 9/17/16.
 */
public class TrappingRainWater {
    //Solution 1
    public static int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        List<Integer> listMaxs = positionMaxValue(height);

        int firstPosMax, lastPosMax;
        if(listMaxs.size() == 2) {
            firstPosMax = listMaxs.get(0);
            lastPosMax = listMaxs.get(1);
        } else {
            firstPosMax = listMaxs.get(0);
            lastPosMax = listMaxs.get(0);
        }

        int sum = 0;
        int maxTemp = Integer.MIN_VALUE;
        for(int index = 0; index < firstPosMax; index++) {
            if(height[index] > maxTemp) {
                maxTemp = height[index];
            } else if (height[index] < maxTemp){
                sum += maxTemp - height[index];
            }
        }

        maxTemp = Integer.MIN_VALUE;
        for(int index = height.length - 1; index >  lastPosMax; index--) {
            if(height[index] > maxTemp) {
                maxTemp = height[index];
            } else if(height[index] < maxTemp) {
                sum += maxTemp - height[index];
            }
        }

        if(listMaxs.size() == 2) {
            maxTemp = height[listMaxs.get(0)];
            for (int index = firstPosMax + 1; index < lastPosMax; index++) {
                sum +=  maxTemp - height[index];
            }
        }

        return sum;
    }

    static List<Integer> positionMaxValue(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        List<Integer> ls = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] > max) {
                max = arr[index];

                ls.clear();
                ls.add(index);
            } else if(arr[index] == max) {
                if(ls.size() == 2) {
                    ls.remove(1);
                }

                ls.add(index);
            }
        }

        return ls;
    }

    //Solution 2
    public static int trapImproved(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int max = 0;

        int left = 0;
        int right = height.length - 1;

        int sum = 0;
        while (left < right) {
            if(max >= height[left]) {
                sum += max - height[left++];
            } else if (max >= height[right]){
                sum += max - height[right--];
            } else {
                max = height[left] < height[right] ? height[left] : height[right];
            }
        }

        return sum;
    }


    public static void main (String[] args) {
        int[] arr = {2, 1, 0 , 2};

        System.out.print(TrappingRainWater.trapImproved(arr));
    }

}
