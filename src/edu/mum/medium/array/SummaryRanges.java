package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/14/17.
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums ==null || nums.length == 0)
            return list;

        int pos = 0;
        while(pos < nums.length) {
            int i = pos;
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if(i > pos)
                list.add(nums[pos] + "->" + nums[i]);
            else
                list.add("" + nums[pos]);

            pos = i + 1;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};

        System.out.print(summaryRanges(nums));
    }
}
