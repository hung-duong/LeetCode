/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.medium.math;

/**
 *
 * @author hungduong
 */
public class PowXN {
    static public double myPow(double x, int n) {
        if(n == 0) return 1;
        
        boolean positive = true;
        if(n < 0) {
            positive = false;
        }
        
        double value = 1.0;
        while(n != 0) {
            if((n & 1) != 0) {
                if (positive) {
                    value = value * x;
                } else {
                    value = value / x;
                }
            }
            n = n / 2;
            x = x * x;
        }
        
        return value;
    }

    public static void main (String[] args) {
        System.out.println(PowXN.myPow(2.00000, -2147483648));
    }
}
