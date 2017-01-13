/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.math;

/**
 *
 * @author hungduong
 * Refer to : https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
 */
public class SqrtX {
    static public double mySqrt(double x) {
        double e = 0.00001;
        double guess = 2;
        double divide = x / guess;
        double averageFirst = (guess + divide) / 2;
        
        do {
           guess = averageFirst;
           divide = x / guess;
           double averageNext = (guess + divide) / 2;
           if (Math.abs(averageNext - averageFirst) < e) {
               break;
           } else {
               averageFirst = averageNext;
           }
        } while(true);
        
        return averageFirst;
    }
    
    static public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x/r) / 2;
        }
        
        return (int)r;
    }

    public static void main (String[] args) {
        System.out.println(SqrtX.mySqrt((double)25));
        System.out.println(SqrtX.mySqrt((int)25));
    }
}
