package edu.mum.easy.dynamicprogramming;

/**
 * Created by hungduong on 1/2/17.
 */

// There is a fence with n posts, each post can be painted with one of the k colors.
// You have to paint all the posts such that no more than two adjacent fence posts have the same color.
// Return the total number of ways you can paint the fence.
public class PaintFence {
    /*
     * Solution: Assuming there are 3 posts, if the first one and the second one has the same color,
     * then the third one has k-1 options. The first and second together has k options.
     * If the first and the second do not have same color, the total is k * (k-1), then the third one has k options.
     * Therefore, f(3) = (k-1)*k + k*(k-1)*k = (k-1)(k+k*k)
     */
    static public int numWays(int n, int k) {
        if (n == 0) return 0;
        else if (n == 1) return k;

        int differentColorOptions = k*k;
        int sameColorOptions = k;

        for(int i = 2; i < n; i++) {
            int temp = (k - 1) * (sameColorOptions + differentColorOptions);
            sameColorOptions = differentColorOptions;
            differentColorOptions = temp;
        }

        return differentColorOptions;
    }

    public static void main(String[] args) {
        int result = numWays(3, 3);

        System.out.print(result);
    }
}
