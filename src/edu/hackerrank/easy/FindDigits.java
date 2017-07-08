package edu.hackerrank.easy;

import java.util.Scanner;

/**
 * Created by hungduong on 7/7/17.
 */
public class FindDigits {
    /**
     * https://www.hackerrank.com/challenges/find-digits
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        while(scan.hasNext()) {
            int num = scan.nextInt();

            int count = 0, tmp = num;
            while (tmp != 0) {
                int digit = tmp % 10;

                if(digit != 0 && num % digit == 0) {
                    count++;
                }
                tmp /= 10;
            }

            System.out.println(count);
        }
    }
}
