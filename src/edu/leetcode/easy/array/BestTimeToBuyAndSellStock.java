package edu.leetcode.easy.array;

/**
 * Created by hungduong on 9/15/16.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

    //Brute force: O(n^2)
    static public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    // Running time: O(n)
    static public int maxProfit2(int[] prices) {
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
        System.out.print(BestTimeToBuyAndSellStock.maxProfit2(prices));
    }
}
