package edu.mum.medium.number;

/**
 * Created by hungduong on 10/16/16.
 */
public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int diff = 0;

        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        for(Integer num : nums) {
            diff = diff ^ num;
        }

        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0 , 0};
        for(Integer num : nums) {
            if((num & diff) == 0) {  // the bit is not set
                rets[0] ^= num;
            } else { // the bit is set
                rets[1] ^= num;
            }
        }

        return rets;
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 6, 4, 5, 2};

        int[] result = SingleNumberIII.singleNumber(test);

        for(Integer r : result) {
            System.out.println(r);
        }

    }
}
