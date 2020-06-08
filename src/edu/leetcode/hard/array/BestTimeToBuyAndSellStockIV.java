package edu.leetcode.hard.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;

        int maxProfit = 0;
        if (k > prices.length / 2) {
            for (int i = 1; i < prices.length; i++) {
                maxProfit += Math.max(prices[i] - prices[i - 1], 0);
            }

            return maxProfit;
        }

        int[] tkCost = new int[k];
        int[] tkProfit = new int[k];

        Arrays.fill(tkCost, Integer.MAX_VALUE);
        Arrays.fill(tkProfit, 0);

        for(int price : prices) {
            tkCost[0] = Math.min(tkCost[0], price);
            tkProfit[0] = Math.max(tkProfit[0], price - tkCost[0]);

            for(int i=1; i<k; i++) {
                tkCost[i] = Math.min(tkCost[i], price - tkProfit[i-1]);
                tkProfit[i] = Math.max(tkProfit[i], price - tkCost[i]);
            }
        }

        return tkProfit[k - 1];
    }


    public static void main(String[] args) {
        int[] A = {2, 1, 2, 0, 1};
        //int[] A = {1, 1, 1, 1};
        //prices = [1, 3] k=0
        //prices = [2, 1, 2, 0, 1] k = 2
        System.out.print(maxProfit(2, A));
    }
}
