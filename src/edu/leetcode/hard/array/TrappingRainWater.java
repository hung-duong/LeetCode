package edu.leetcode.hard.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hungduong on 9/17/16.
 */
public class TrappingRainWater {

    // Solution 1: Brute Force with O(n*n) complexity and O(1) spance
    static int trapBruteForce(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int ans = 0;
        for(int i=0; i<height.length; i++) {
            int leftMax = 0, rightMax = 0;

            for (int j=0; j<=i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j=i; j<height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }

    // Solution 2: Dynamic Programming (Inspired from solution 1)
    // Complexity O(n) and O(n + n) space => O(n)
    public static int trapDP(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = height[i] > leftMax[i-1] ? height[i] : leftMax[i - 1];
            // leftMax[i] = Math.max(height[i], leftMax[i-1])
        }

        rightMax[height.length - 1] = height[height.length -1];
        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = height[i] > rightMax[i + 1] ? height[i] : rightMax[i + 1];
            // rightMax[i] = Math.max(height[i], rightMax[i + 1])
        }

        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }


    // Solution 3: Use stacks (improved a little bug from solution 1)
    public static int trapUseStack(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int ans = 0, current = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int top = stack.peek();
                stack.pop();

                if(stack.isEmpty())
                    break;

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(current++);
        }

        return ans;
    }

    //Solution 1
    public static int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        List<Integer> listMaxs = positionMaxValue(height);

        int firstPosMax, lastPosMax;
        if(listMaxs.size() == 2) {
            firstPosMax = listMaxs.get(0);
            lastPosMax = listMaxs.get(1);
        } else {
            firstPosMax = listMaxs.get(0);
            lastPosMax = listMaxs.get(0);
        }

        int sum = 0;
        int maxTemp = Integer.MIN_VALUE;
        for(int index = 0; index < firstPosMax; index++) {
            if(height[index] > maxTemp) {
                maxTemp = height[index];
            } else if (height[index] < maxTemp){
                sum += maxTemp - height[index];
            }
        }

        maxTemp = Integer.MIN_VALUE;
        for(int index = height.length - 1; index >  lastPosMax; index--) {
            if(height[index] > maxTemp) {
                maxTemp = height[index];
            } else if(height[index] < maxTemp) {
                sum += maxTemp - height[index];
            }
        }

        if(listMaxs.size() == 2) {
            maxTemp = height[listMaxs.get(0)];
            for (int index = firstPosMax + 1; index < lastPosMax; index++) {
                sum +=  maxTemp - height[index];
            }
        }

        return sum;
    }

    static List<Integer> positionMaxValue(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        List<Integer> ls = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] > max) {
                max = arr[index];

                ls.clear();
                ls.add(index);
            } else if(arr[index] == max) {
                if(ls.size() == 2) {
                    ls.remove(1);
                }

                ls.add(index);
            }
        }

        return ls;
    }

    //Solution 4: 2 Pointers approach
    // Complexity O(n) and Space O(1)
    public static int trapImproved1(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int max = 0;

        int left = 0;
        int right = height.length - 1;

        int sum = 0;
        while (left < right) {
            if(max >= height[left]) {
                sum += max - height[left++];
            } else if (max >= height[right]){
                sum += max - height[right--];
            } else {
                max = height[left] < height[right] ? height[left] : height[right];
            }
        }

        return sum;
    }

    public static int trapImproved2(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;
    }

    public static void main (String[] args) {
        // int[] arr = {0, 1, 0, 2,1,0,1,3,2,1,2,1};
        int[] arr = {4, 2, 0, 3, 2, 5};

        System.out.print(TrappingRainWater.trapDP(arr));
    }

}
