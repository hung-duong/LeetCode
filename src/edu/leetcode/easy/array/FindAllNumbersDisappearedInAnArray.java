package edu.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/11/17.
 */
public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        //The value of element in nums are similar to index in array, so there will be duplicated
        //=>It will miss some the value not in 1 -> n
        //Eg. 4,3,2,5,8,2,3,1 => miss 5,6
        //math.abs(index) - 1 in nums to avoid overflow exeception when value in range 1 -> n
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if(nums[Math.abs(index) - 1] > 0) {
                nums[Math.abs(index) - 1] = - nums[Math.abs(index) - 1];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,5,8,2,3,1};

        System.out.print(findDisappearedNumbers(nums));
    }
}
