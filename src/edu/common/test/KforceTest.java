package edu.common.test;

/**
 * Created by hungduong on 5/16/17.
 */
public class KforceTest {
    public static int solution(int[] A) {
        if(A == null || A.length == 0) return 0;

        //boolean[] B = new boolean[A.length];

        /*
        int lo = 0, hi = 0;
        B[A[hi]] = true;
        for(int index = 1; index < A.length; index++) {
            if(!B[A[index]]) {
               B[A[index]] = true;
               hi = index;
            } else if(A[lo] == A[index]) {
               lo++;
               hi = index;
            }
        }

        if(lo > hi)
            return 1;*/

        int[] nums = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            nums[A[i]]++;
        }

        int lo = 0, hi = A.length - 1;
        while(lo < hi) {
            boolean b1 = false;
            if(nums[A[lo]] > 1) {
                b1 = true;
                nums[A[lo]]--;
                lo++;
            }

            boolean b2 = false;
            if(nums[A[hi]] > 1) {
                b2 = true;
                nums[A[hi]]--;
                hi--;
            }

            if(!(b1 || b2)) break;
        }

        return hi - lo + 1;
    }

    public static void main(String[] args) {
        int[] A = {7, 3, 7, 3, 1, 3, 4, 1};
        //int[] A = {1, 1, 1, 1};
        System.out.print(solution(A));
    }
}
