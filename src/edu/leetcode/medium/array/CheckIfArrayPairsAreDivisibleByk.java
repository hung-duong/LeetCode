package edu.leetcode.medium.array;

import java.util.Arrays;

public class CheckIfArrayPairsAreDivisibleByk {
    // O(n*n) => Time Limit Exceeded
    public static boolean canArrange1(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return false;

        Arrays.sort(arr);

        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            for (int j = arr.length - 1; j > i; j--) {
                if ((arr[i] + arr[j]) % k == 0 && !visited[j]) {
                    visited[i] = true;
                    visited[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i])
                return false;
        }

        return true;
    }


    // O(nlogn) => FAILED some cases
    public static boolean canArrange2(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return false;

        Arrays.sort(arr);

        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        for(int i = arr.length - 1; i >= 0; i--) {
            if (visited[i]) continue;

            int target;
            if (arr[i] >= k) {
                target = (-1) * arr[i] % k >= arr[0] ? (-1) * arr[i] % k : k - arr[i] % k;
            } else {
                target = k - arr[i] < arr[i] ? k - arr[i] : (-1)*arr[i];
            }

            int left = 0, right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < target) {
                    left = mid + 1;
                } else if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                    while(left > 0 && arr[left - 1] == target) {
                        left--;
                    }

                    right = mid;
                    while(right < arr.length - 1 && arr[right + 1] == target) {
                        right++;
                    }

                    for (int j = left; j <= right; j++) {
                        if (!visited[j]) {
                            visited[i] = true;
                            visited[j] = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i])
                return false;
        }

        return true;
    }

    // O(n) => Could be failed because missing test cases [1, 1, 2, 3, 1, 1], 3
    public static boolean canArrange3(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return false;

        long sum = 0;
        for(int num : arr) {
            sum += num;
        }

        if (sum % k == 0)
            return true;

        return false;
    }


//    O(n)
//    Idea :
//    Given 2 nums 'a' and 'b':
//    If a % k == x and b % k == k - x :
//    then (a + b) is divisible by k
    public static boolean canArrange4(int[] arr, int k) {
        int[] frequency = new int[k];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] % k;
            if (num < 0)
                num += k;
            frequency[num]++;
        }

        if (frequency[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {75,5,-5,75,-2,-3,88,10,10,87};
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {-10, 10};

        System.out.print(canArrange2(arr, 2));
    }
}
