package edu.leetcode.medium.array;

public class GastStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        int surplus = 0;
        int totalSurplus = 0;

        for (int i = 0; i < len; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        return totalSurplus < 0 ? -1 : start;
    }
}
