/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.easy.math;

/**
 *
 * @author hungduong
 */
public class PowerOfTwo {

    //Solution 1: Bad, it take O(n)
    static public boolean isPowerOfTwoSol1(int n) {
        if(n <= 0) return false;
        
        while(n % 2 != 1) {
            n /= 2;
        }
        
        return n == 1;
    }

    //Solution 2: Better, O(1)
    static public boolean isPowerOfTwoSol2(int n) {
        return (n > 0) && ((n & (n-1)) == 0);
    }

    public static void main (String[] args) {
        int s = -8;
        System.out.println(PowerOfTwo.isPowerOfTwoSol2(s));
    }
}
