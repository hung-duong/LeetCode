package edu.common.test;

import edu.common.Utils.TreeNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 5/31/17.
 */
public class Indtest {
    //Question 1
    private static int isPresent(TreeNode root, int val){
        TreeNode node = root;

        while(node != null) {
            if(val < node.val) {
                node = node.left;
            } else if(val > node.val) {
                node = node.right;
            } else {
                return 1;
            }
        }

        return 0;
    }

    //Question 2
    public static int[] getMinimumUniqueSum(String[] arr) {
        if(arr == null || arr.length == 0) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        for(String str : arr) {
            String[] nums = str.split(" ");

            if(nums.length == 1) continue;

            int first = Integer.parseInt(nums[0]);
            int second = Integer.parseInt(nums[1]);

            if (first > second) {
                int tmp = first;
                first = second;
                second = tmp;
            }

            int n = (int)Math.sqrt(first);
            int count = (int)Math.sqrt(second) - n;
            if(n*n == first) {
                count++;
            }

            list.add(count);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    //Question 3
    public String doesCircleExist(String commands) {
        if(commands == null || commands.length() == 0) return "NO";

        char[] path = commands.toCharArray();
        int x = 0, y = 0;
        int angle = 0;

        for(Character command : path) {
            switch (command) {
                case 'G':
                    if(angle == 0) {
                        x++;
                    } else if(angle == 90 || angle == -270) {
                        y++;
                    } else if(angle == 180 || angle == -180) {
                        x--;
                    } else if (angle == 270 || angle == -90) {
                        y--;
                    }
                    break;
                case 'L':
                    angle = (angle + 90) % 360;
                    break;
                case 'R':
                    angle = (angle - 90) % 360;
                    break;
            }
        }

        if((x != 0 || y !=0) && (angle == 0)) return "NO";

        return "YES";
    }

    //Question 4
    public static String[] readOperation(String FileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String[] operations;
        int n = 0;

        String currentLine;
        if((currentLine = br.readLine()) != null) {
            n = Integer.parseInt(currentLine);
        }

        if(n <= 0) return null;

        operations = new String[n];
        int index = 0;
        while((currentLine = br.readLine()) != null && index < n) {
            operations[index++] = currentLine;
        }

        return operations;
    }

    public static void SuperStack(String FileName) throws IOException{
        String[] operations = readOperation(FileName);
        if(operations == null) return;

        List<Long> stack = new ArrayList<>();
        List<Long> increments = new ArrayList<>();

        for(String str : operations) {
            String[] sub = str.split(" ");
            switch (sub[0]) {
                case "push":
                    stack.add(Long.parseLong(sub[1]));
                    increments.add(0L);

                    System.out.println(stack.get(stack.size() - 1));
                    break;
                case "pop":
                    stack.remove(stack.size() - 1);
                    if(stack.size() == 0) {
                        System.out.println("EMPTY");

                        increments.remove(increments.size() - 1);
                    } else {
                        stack.set(stack.size() - 1, stack.get(stack.size() - 1) + increments.get(increments.size() - 1));

                        Long value = increments.get(increments.size() - 1);
                        increments.remove(increments.size() - 1);
                        increments.set(increments.size() - 1, increments.get(increments.size() - 1) + value);

                        System.out.println(stack.get(stack.size() - 1));
                    }
                    break;
                case "inc":
                    int x = Integer.parseInt(sub[1]);
                    int d = Integer.parseInt(sub[2]);

                    increments.set(x - 1, increments.get(x - 1) + d);
                    stack.set(x - 1, stack.get(x - 1) + d);

                    System.out.println(stack.get(stack.size() - 1));
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Indtest kp = new Indtest();

        String commands = "GLGLGLGL";

        System.out.println(kp.doesCircleExist(commands));

        //String filename = "./src/edu/leetcode/Test/input.txt";
        //SuperStack(filename);
    }

}
