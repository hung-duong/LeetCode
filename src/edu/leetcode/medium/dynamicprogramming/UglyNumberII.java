/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.medium.dynamicprogramming;

/**
 *
 * @author hungduong
 */
public class UglyNumberII {
    static public int nthUglyNumber(int n) {
        /*if (n == 1) return 1;
        
        int temp = 0;
        for (int i = 2, countUgly = 1; ; i++) {
            temp = i;
            while (temp % 2 == 0) {
                temp /= 2;
            }
            
            while (temp % 3 == 0) {
                temp /= 3;
            }
            
            while (temp % 5 == 0) {
                temp /= 5;
            }
            
            if (temp == 1)
                countUgly++;
            else
                continue;
                
            if(countUgly == n)
                return i;
        }*/
        
        int[] uglyNumbers = new int[n];
        
        int last2 = 0, last3 = 0, last5 = 0;
        uglyNumbers[0] = 1;
        
        for(int i = 1; i<n; i++) {

            int min = Math.min(Math.min(2*uglyNumbers[last2], 3*uglyNumbers[last3]), 5*uglyNumbers[last5]);

            uglyNumbers[i] = min;

            if(2*uglyNumbers[last2] == min) {
                last2++;
            }
            
            if(3*uglyNumbers[last3] == min) {
                last3++;
            }
            
            if(5*uglyNumbers[last5] == min) {
                last5++;
            }
        }
        
        return uglyNumbers[n-1];
    }
    

    public static void main (String[] args) {
        System.out.println(UglyNumberII.nthUglyNumber(1352));
    }
}
