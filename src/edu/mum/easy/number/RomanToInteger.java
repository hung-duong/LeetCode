package edu.mum.easy.number;

/**
 * Created by hungduong on 4/27/17.
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] nums = new int[n];

        for(int index = 0; index < n; index++) {
            switch (s.charAt(index)) {
                case 'M' :
                    nums[index] = 1000;
                    break;
                case 'D' :
                    nums[index] = 500;
                    break;
                case 'C' :
                    nums[index] = 100;
                    break;
                case 'L' :
                    nums[index] = 50;
                    break;
                case 'X' :
                    nums[index] = 10;
                    break;
                case 'V' :
                    nums[index] = 5;
                    break;
                case 'I' :
                    nums[index] = 1;
                    break;
            }
        }

        int num = 0;
        for(int index = 0; index < n - 1; index++) {
            if(nums[index] < nums[index + 1]) {
                num -= nums[index];
            } else {
                num += nums[index];
            }
        }

        return num + nums[n - 1];
    }

    public static void main(String[] args) {
        String s = "CCCXCVIII";

        System.out.print(RomanToInteger.romanToInt(s));
    }
}
