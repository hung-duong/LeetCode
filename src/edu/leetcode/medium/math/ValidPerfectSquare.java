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
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long r = num;
        
        while(r * r > num) {
            r = (r + num / r) / 2;
        }
        
        if(r * r == num) {
            return true;
        }
        
        return false;
    }
}
