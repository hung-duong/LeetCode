package edu.leetcode.medium.dynamicprogramming;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        return 0;
    }

    private static Integer randomInteger() {
        return new Random(1000).nextInt();
    }

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();

        for (int i=0; i<100; i++) {
            s.add(randomInteger());
        }

        Random r = new Random(1000);
        System.out.println(r.nextInt());
        System.out.println(r.nextInt());
        System.out.println(r.nextInt());
//        -1244746321
//        1060493871
//                -1826063944

//        System.out.println(s.size());

    }

}
