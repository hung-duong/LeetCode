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

    // Explain from https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    // case 1 with k=1
    public static int maxProfit3(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        for (int i=0; i<prices.length; i++) {
            T_i10 = Math.max(T_i10, T_i11 + prices[i]);
            T_i11 = Math.max(T_i11, -prices[i]);
        }

        return T_i10;
    }


    public static void main (String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.print(BestTimeToBuyAndSellStock.maxProfit2(prices));
    }
}
