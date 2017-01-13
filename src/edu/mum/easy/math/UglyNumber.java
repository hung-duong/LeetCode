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
public class UglyNumber {
    static public boolean isUglySol01(int num) {
        if (num <= 0) return false;
        
        while (true) {
            if(num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                break;
            }
        }
        
        return num == 1;
    }

    //Other similar code which is more shortest
    static public boolean isUglySol02(int num) {
        if (num <= 0) return false;

        for(int i = 2; i < 6; i++) {
            while(num % i == 0) {
                num /= i;
            }
        }

        return num == 1;
    }
    
    static boolean isPrime(int n) {
        if(n % 2 == 0) 
            return false;
        
        //If not, then just check the odds
        for(int i = 3; i*i <= n; i += 2)
            if(n % i == 0)
                return false;
        
        return true;
    }

    public static void main (String[] args) {
        System.out.println(UglyNumber.isUglySol02(1332185066));
    }
}
