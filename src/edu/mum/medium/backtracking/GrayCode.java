package edu.mum.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/25/17.
 */
public class GrayCode {
    //backtracking => this method gives unexpected result
    public static List<Integer> grayCode01(int n) {
        List<Integer> result = new ArrayList<>();

        grayCodeHelper(n, new StringBuilder(), result);

        return result;
    }

    public static void grayCodeHelper(int n, StringBuilder str, List<Integer> result) {
        if(n == 0) {
            result.add(binaryToInteger(str.toString()));
            return;
        }

        for(int j = 0; j <= 1; j++) {
            str.append(j);
            grayCodeHelper(n - 1, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static int binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        int result = 0;
        for(int i = numbers.length - 1; i >= 0; i--)
            if(numbers[i]=='1')
                result += Math.pow(2, (numbers.length-i - 1));
        return result;
    }

    //This method gives expected result.
    // Refer to link https://en.wikipedia.org/wiki/Gray_code
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = grayCode(3);

        for(Integer i : result) {
            System.out.println(i);
        }
    }
}
