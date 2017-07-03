package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 10/8/16.
 */
public class UniqueBinarySearchTrees {

    /*
    * G(n): the number of unique BST for a sequence of length n.
    * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
    * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
    * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    *
    * Combining the above two formulas, we obtain the recursive formula for G(n)
    * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)  with G(0)=1, G(1)=1
    */

    public static int numTrees(int n) {
        int[] eles = new int[n + 1];

        eles[0] = 1;
        eles[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                eles[i] += eles[j - 1] * eles[i - j];
            }
        }

        return eles[n];
    }


    public static void main(String[] args) {
        System.out.print(UniqueBinarySearchTrees.numTrees(2));
    }
}
