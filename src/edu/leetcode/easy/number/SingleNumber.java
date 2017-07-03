package edu.leetcode.easy.number;

/**
 * Created by hungduong on 10/16/16.
 */


public class SingleNumber {

    /*we use bitwise XOR to solve this problem :
    first , we have to know the bitwise XOR in java
    0 ^ N = N
    N ^ N = 0
    So..... if N is the single number
    N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    = 0 ^ 0 ^ ..........^ 0 ^ N
    = N
    */

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
