/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.easy.combination;

/**
 *
 * @author hungduong
 */
public class StrobogrammaticNumber {
    static public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
         
        boolean isEven = false;
        if(num.length() % 2 == 0) {
            isEven = true;
        }
        
        char c1, c2;
        int i = 0;
        while(i < num.length()/2) {
            c1 = num.charAt(i);
            c2 = num.charAt(num.length() - 1 - i);
                
            if((c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6')) {
                i++;
            } else if (c1 == c2) {
                if(isStrobog(c1)) i++;
            } else {
                return false;
            }
        }
        
        if(!isEven) {
            if(!isStrobog(num.charAt(num.length()/2)))
                return false;
        }
        
        return true;
     }
     
    static public boolean isStrobog(char c) {
         return c == '0' || c == '1' || c == '8';
    }

    public static void main (String[] args) {
        System.out.println(StrobogrammaticNumber.isStrobogrammatic("689"));
    }
}
