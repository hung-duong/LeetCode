package edu.mum.easy.array;

/**
 * Created by hungduong on 9/15/16.
 */
public class BestTimeToBuyAndSellStock {
    static public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            } else if (maxProfit < prices[i] - min) {
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;
    }


    public static void main (String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.print(BestTimeToBuyAndSellStock.maxProfit(prices));
    }
}
