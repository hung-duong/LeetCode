package edu.leetcode.medium.array;

public class BestTimeToBuyAndSellStockWithCoolDown {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    // Case V: k = +Infinity but with cooldown
    // This case resembles Case II very much due to the fact that they have the same k value, except now the recurrence relations have to be modified slightly to account for the "cooldown" requirement.
    // But with "cooldown", we cannot buy on the i-th day if a stock is sold on the (i-1)-th day. 
    // Therefore, in the second equation above, instead of T[i-1][k][0], we should actually use T[i-2][k][0] if we intend to buy on the i-th day. 
    // Everything else remains the same and the new recurrence relations are

    // T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
    // T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])

    public int maxProfit(int[] prices, int fee) {
        int t_ik0 = 0, t_ik0_pre = 0;
        int t_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int t_ik0_old = t_ik0;
            t_ik0 = Math.max(t_ik0, t_ik1 + price);
            t_ik1 = Math.max(t_ik1, t_ik0_pre - price);
            t_ik0_pre = t_ik0_old;
        }

        return t_ik0;
    }
}
