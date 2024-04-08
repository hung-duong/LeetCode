package edu.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    
    public static String largestNumber(int[] nums) {
        int len = nums.length;

        // Covert nums to string
        String[] numsStr = new String[len];
        for (int i = 0; i < len; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        // Sorting 
        Arrays.sort(numsStr, new Comparator<String>() {
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                return str2.compareTo(str1);
            }
        });

        if(numsStr[0].equals("0"))
            return "0";

        String ans = "";
        for(int i=0 ; i < len; i++) {
            ans = ans + numsStr[i];
        }

        return ans;
    }

    public static void main (String[] args) {
        int[] nums = new int[]{3, 30, 34, 5 , 9};

        largestNumber(nums);
    }
}
