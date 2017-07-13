package edu.hackerrank.easy.array;

/**
 * Created by hungduong on 7/11/17.
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        int n = 7;
        int[] c = {0, 0, 1, 0, 0, 1, 0};

        if (n == 2) {
            System.out.print(1);
        } else {
            int[] d = new int[n];
            d[0] = 0;
            d[1] = c[1] == 1 ? Integer.MAX_VALUE : 1;
            for (int i = 2; i < n; i++) {
                if (c[i] == 0)
                    d[i] = Math.min(d[i - 1], d[i -2]) + 1;
                else
                    d[i] = Integer.MAX_VALUE;
            }

            System.out.print(d[n - 1]);
        }
    }
}
