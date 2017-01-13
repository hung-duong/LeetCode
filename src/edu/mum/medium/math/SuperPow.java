/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.math;

/**
 *
 * @author hungduong
 * Refer to Fermat's little theorem: https://en.wikipedia.org/wiki/Fermat%27s_little_theorem
 * and Euler's theorem: https://en.wikipedia.org/wiki/Euler%27s_theorem
 */
public class SuperPow {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        if(a % mod == 0) return 0;
        
        int p = 0;
        for(int i : b) {
            p = (p * 10 + i) % 1140;
        }
        
        if(p == 0) p += 1140;
        
        return ipow(a, p);
    }
    
    public int ipow(int base, int exp) {
        base %= mod;
        
        int result = 1;
        while(exp != 0) {
            if ((exp & 1) != 0)
                result = result * base % mod;
            exp >>= 1;
            base = base * base % mod;
        }
        
        return result;
    }

    public static void main (String[] args) {
        SuperPow sp = new SuperPow();
        System.out.println(sp.superPow(2147483647, new int[]{2, 0, 0}));
        //System.out.println(sp.ipow(Integer.MAX_VALUE, 1337));
    }
}
