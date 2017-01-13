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
public class StringToInteger {
    static public int myAtoi(String str) {
        str = str.trim();
        if(str.trim().isEmpty()) {
            return 0;
        }
        
        int pointer = 0;
        int sign = 1;
        if (str.charAt(pointer) == '-') {
            sign = -1;
            pointer++;
        } else if(str.charAt(pointer) == '+') {
            pointer++;
        }
        
        long value = 0;
        while(pointer < str.length() && (str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9')) {
                value = value * 10 + (str.charAt(pointer) - '0');
                
                if (sign * value > Integer.MAX_VALUE) {
                    return sign * Integer.MAX_VALUE;
                } else if (sign * value < Integer.MIN_VALUE) {
                    return sign * Integer.MIN_VALUE;
                }
                
                pointer++;
        }
       
        return (int)(sign * value);
    }

    public static void main (String[] args) {
        String s = "9223372036854775809";
        System.out.println(StringToInteger.myAtoi(s));
    }
}
