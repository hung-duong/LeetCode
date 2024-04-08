package edu.leetcode.medium.array;

/**
 * Created by hungduong on 1/16/17.
 */
public class BestTimeToBuyAndSellStockII {
    /*
     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * Eg: [7, 2, 1, 10, 2, 5] => maxProfit = 12 = 10 - 1 + 5 - 2
     * O(n) and O(1)
     */
    public static int maxProfit1(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        int i = 0;
        while(i < prices.length) {
            //find minimum
            while(i < prices.length && prices[i] <= min)
                min = prices[i++];

            int max = min;
            //find maximum
            while(i < prices.length && prices[i] >= max)
                max = prices[i++];

            if(max > min) {
                maxProfit += max - min;
                min = Integer.MAX_VALUE;
            }
        }

        return maxProfit;
    }

    // O(n) and O(1)
    public static int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        for (int i = 1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }

    // Explain from https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    // Case II: k = +Infinity
    public static int maxProfit3(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        
        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }
        
        return T_ik0;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 1, 10, 2, 5};
        System.out.print(maxProfit1(nums));
    }
}
