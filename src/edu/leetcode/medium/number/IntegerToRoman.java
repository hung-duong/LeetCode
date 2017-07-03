package edu.leetcode.medium.number;

/**
 * Created by hungduong on 10/5/16.
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        if(num <= 0) return "";

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romains = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int index = 0;

        while(num > 0) {
            int divide = num / nums[index];
            num = num - nums[index] * divide;

            while (divide > 0) {
                res.append(romains[index]);
                divide--;
            }
            index++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        int num = 398;

        System.out.print(IntegerToRoman.intToRoman(num));
    }
}
