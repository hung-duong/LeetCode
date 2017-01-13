package edu.mum.easy.dynamicprogramming;

/**
 * Created by hungduong on 1/3/17.
 */
public class ClimbingStairs {
    //Solution: O(n) and 0(n) space
    public static int climbStairs01(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;

        for(int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n - 1];
    }

    //Solution: O(n) and 0(1) space
    public static int climbStairs02(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int first = 1, second = 2;
        int ways = 0;

        for(int i = 2; i < n; i++) {
            ways = first + second;
            first = second;
            second = ways;
        }

        return ways;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.print(climbStairs02(n));
    }
}
