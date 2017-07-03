package edu.leetcode.hard.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by hungduong on 10/24/16.
 */
public class FrogJump {
    public static boolean canCross(int[] stones) {
        int len = stones.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < len - 1; i ++) {
            for (int step : map.get(stones[i])) {
                int to = step + stones[i];
                if (to == stones[len - 1]) {
                    return true;
                }
                HashSet<Integer> tmp = map.get(to);
                if (tmp != null) {
                    tmp.add(step);
                    if (step > 1) {
                        tmp.add(step - 1);
                    }
                    tmp.add(step + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};

        System.out.print(FrogJump.canCross(stones));
    }
}
