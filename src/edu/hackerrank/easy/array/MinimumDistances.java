package edu.hackerrank.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 7/6/17.
 */
public class MinimumDistances {
    /**
     * https://www.hackerrank.com/challenges/minimum-distances
     */

    //Solution 1: O(n^2)
    public static int findMinimumDistances01(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    minLen = Math.min(j - i, minLen);
                }
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : -1;
    }


    //Solution 1: O(n) running time and O(n) space
    public static int findMinimumDistances02(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }

        //Use the map to track the position
        Map<Integer, Integer> map = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int j = map.get(arr[i]);
                minLen = Math.min(Math.abs(j - i), minLen);
            }

            map.put(arr[i], i);
        }

        return minLen != Integer.MAX_VALUE ? minLen : -1;
    }


    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 4, 1, 7, 1, 7};

        System.out.print(findMinimumDistances02(arr));
    }
}
