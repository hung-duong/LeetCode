package edu.mum.hard.array;

/**
 * Created by hungduong on 4/19/17.
 */
public class BestTimeToBuyAndSellStockIII {
    // Design an algorithm to find the maximum profit. You may complete at most two transactions.
    // Note: A transaction is a buy & a sell
    // We can solve by "devide and conquer". We use left[i] to track the maximum profit for transactions before i,
    // and use right[i] to track the maximum profit for transactions after i.
    // Ex: Prices = 1 4 5 7 6 3 2 9
    //     left = [0, 3, 4, 6, 6, 6, 6, 8]
    //     right= [8, 7, 7, 7, 7, 7, 7, 0]
    //     maximum profit = 13
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        //Highest profit in 0...i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        //Maximum profit for transactions after i
        int min = prices[0];
        left[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //Maximum profit for transactions atfer i
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
