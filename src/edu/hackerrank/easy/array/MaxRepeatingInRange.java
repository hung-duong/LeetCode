package edu.hackerrank.easy.array;

/**
 * Created by hungduong on 7/20/17.
 */
public class MaxRepeatingInRange {
    /**
     * arr = {a1, a2, a3, ..., an}
     * 0 <= ai < n
     */
    public static int maxRepeating(int[] arr) {
        int len = arr.length;

        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        for (int i = 0; i< len; i++) {
            arr[arr[i] % len] += len;
        }

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < len; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }

        // Return index of the maximum element
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 3, 4, 6};
        int res = maxRepeating(arr);
        System.out.println();
        System.out.print(res);
    }
}
