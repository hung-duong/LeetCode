package edu.hackerrank.easy.string;

import java.util.Scanner;

/**
 * Created by hungduong on 7/4/17.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        char[] chars = s.toCharArray();
        int count = 1;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] - 'A' >= 0 && chars[i] - 'A' <= 25) count++;
        }

        System.out.println(count);
    }
}
