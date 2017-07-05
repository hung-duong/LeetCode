package edu.hackerrank.medium.bitmanipulation;

import java.util.Scanner;

/**
 * Created by hungduong on 7/4/17.
 */
public class ANDProduct {
    /**
     * Link: https://www.hackerrank.com/challenges/and-product/problem
     * Solution: And of a -> b  => a & (a + 2^0) & (a + 2^1) & (a + 2^2) & (a + 2^3) ... b
     * @param args
     */
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while(n > 0) {
            long a = scan.nextLong();
            long b = scan.nextLong();

            long c = a, index = 0;
            while(c < b) {
                c += 1 << index;
                a = a & c;
                index++;
            }
            a = a & b;

            System.out.println(a);
            n--;
        }
    }
}
