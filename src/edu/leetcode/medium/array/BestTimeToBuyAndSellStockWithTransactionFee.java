package edu.leetcode.medium.array;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    //Solution 1: DP - O(n) and O(1) space
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    // Case VI: k = +Infinity but with transaction fee

    public int maxProfit(int[] prices, int fee) {
        int t_ik0 = 0, t_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int t_ik0_old = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + price);
            t_ik1 = Math.max(t_ik1, t_ik0_old - price - fee);
        }

        return t_ik0;
    }


}
