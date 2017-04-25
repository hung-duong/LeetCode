/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.easy.number;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungduong
 * Refer to: https://en.wikipedia.org/wiki/Happy_number
 */
public class HappyNumber {
    static public boolean isHappySol01(int n) {
        if (n < 0) return false;
        
        if (n == 1) return true;
        
        List<Integer> inLoop = new ArrayList<>();
        
        while(n != 1) {
            int value = 0;
            int digit = 0;
            while(n != 0) {
                digit = n % 10;
                value += digit*digit;
                n = n / 10;
            }
            n = value;
            if (!inLoop.contains(n))
                inLoop.add(n);
            else
                break;
        }
        
        return n == 1;
    }

    //we can simply adapt the Floyd Cycle detection algorithm
    //https://en.wikipedia.org/wiki/Cycle_detection
    static public boolean isHappySol02(int n) {
        int slow, fast;
        slow = fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);

        if(slow == 1) return true;
        else return false;
    }

    static int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public static void main (String[] args) {
        System.out.print(HappyNumber.isHappySol02(998));
    }
}
