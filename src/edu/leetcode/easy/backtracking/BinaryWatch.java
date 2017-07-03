package edu.leetcode.easy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/17/17.
 */
public class BinaryWatch {
    //Use backtracking algorithm
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if(num == 0) {
            list.add("0:00");
            return list;
        }

        int[] hours = new int[4];
        int[] minutes = new int[6];

        hours[0] = 1;
        for(int i = 1; i < hours.length; i++) hours[i] = hours[i - 1] << 1;

        minutes[0] = 1;
        for(int i = 1; i < minutes.length; i++) minutes[i] = minutes[i - 1] << 1;

        for(int i = 0; i <= num; i++) {
            List<Integer> left = readBinaryWatchHelper(hours, i);
            List<Integer> right = readBinaryWatchHelper(minutes, num - i);

            for(Integer l : left) {
                if(l >= 12) continue;
                for(Integer r : right) {
                    if(r >= 60) continue;
                    list.add(l + ":" + (r < 10 ? "0" + r : r));
                }
            }
        }

        return list;
    }

    public List<Integer> readBinaryWatchHelper(int[] nums, int n) {
        List<Integer> result = new ArrayList<>();

        combinationHelper(nums, n, 0, 0, result);

        return result;
    }

    public void combinationHelper(int[] nums, int n, int pos, int sum, List<Integer> result) {
        if(n == 0) {
            result.add(sum);
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            combinationHelper(nums, n - 1, i + 1, sum + nums[i], result);
        }
    }

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        List<String> list = bw.readBinaryWatch(2);

        list.forEach(System.out::println);
    }
}
