/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.hard.math;

/**
 *
 * @author hungduong
 */
public class ValidNumber {
    //Use the pattern: bad solution
    static public boolean isNumber01(String s) {
        if(s.trim().isEmpty()) {
            return false;
        }
        
        String pat = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        
        if(s.trim().matches(pat)) {
            return true;
        } else {
            return false;
        }
    }

    //Good solution
    static public boolean isNumber02(String s) {
        return false;
    }

    public static void main (String[] args) {
        String s = "1.";
        System.out.println(ValidNumber.isNumber01(s));
    }
}
