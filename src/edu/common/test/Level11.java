package edu.common.test;

/**
 * Created by hungduong on 6/28/17.
 */
public class Level11 {
    public static long calculateAmount(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        long min = prices[0];
        long total = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > min) {
                total += prices[i] - min;
            } else {
                min = prices[i];
            }
         }

         return total;
    }

    public static void main(String[] args) {
        int[] prices = {4, 4, 9, 2, 3};
        System.out.print(calculateAmount(prices));
    }
}
