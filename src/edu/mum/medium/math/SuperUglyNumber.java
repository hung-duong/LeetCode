/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.math;

/**
 *
 * @author hungduong
 */
public class SuperUglyNumber {
    static public int nthSuperUglyNumber(int n, int[] primes) {
        long[] uglyNumbers = new long[n];
        
        int[] lastIth = new int[primes.length];
        for(int i = 0; i < primes.length; i++) {
            lastIth[i] = 0;
        }
        
        uglyNumbers[0] = 1;
        long min;
        
        for(int i = 1; i < n; i++) {
            min = Long.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                min = min > primes[j] * uglyNumbers[lastIth[j]] ? primes[j] * uglyNumbers[lastIth[j]] : min;
            }
            
            uglyNumbers[i] = min;
            
            for(int j = 0; j < primes.length; j++) {
                if(primes[j] * uglyNumbers[lastIth[j]] == uglyNumbers[i]) {
                    lastIth[j]++;
                }
            }
        }
        
        return (int)uglyNumbers[n - 1];
    }

    public static void main (String[] args) {
        System.out.println(SuperUglyNumber.nthSuperUglyNumber(12, new int[]{2,3,5}));
    }
}
