package edu.mum.Test;

import java.util.*;

/**
 * Created by hungduong on 5/31/17.
 */
public class IndeedTest {
    //Question 2
    public static List<Integer> getMinimumUniqueSum(String[] arr) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return res;
        }

        for(String str : arr) {
            String[] nums = str.split(" ");
            if(nums.length == 1) continue;
            int firstNum = Integer.parseInt(nums[0]);
            int secondNum = Integer.parseInt(nums[1]);
            if (firstNum > secondNum) {
                int tmp = firstNum;
                firstNum = secondNum;
                secondNum = tmp;
            }

            int count = 0;
            for(int i = firstNum; i <= secondNum; i++) {
                int j = (int)Math.sqrt(i);
                if(i == (j << 1)) {
                    count++;
                }
            }

            res.add(count);
        }

        return res;
    }

    //Question 3
    public boolean doesCircleExist(String commands) {
        if(commands.length() == 1 && (commands.charAt(0) == 'L' || commands.charAt(0) == 'R')) {
            return true;
        }

        char[] path = commands.toCharArray();
        Point start = new Point(0, 0);
        Set<Point> visited = new HashSet<>();
        visited.add(start);

        return doesCircleExist(path, 0, start, 90, visited);
    }

    public boolean doesCircleExist(char[] path, int pos, Point start, int angle, Set<Point> visited) {
        if(pos >= path.length)
            return false;

        Point p = null;
        switch (path[pos]) {
            case 'G':
                if(angle == 180 || angle == -180) {
                    p = new Point(start.x, start.y - 1);
                } else if(angle == 0 || angle == -360) {
                    p = new Point(start.x, start.y + 1);
                } else if(angle == 90 || angle == -270) {
                    p = new Point(start.x - 1, start.y);
                } else if (angle == 270 || angle == -90) {
                    p = new Point(start.x + 1, start.y);
                }

                if(!visited.add(p)) {
                    return true;
                }
                break;
            case 'L':
                angle = (angle - 90) % 360;
                break;
            case 'R':
                angle = (angle + 90) % 360;
                break;
        }

        if(p != null)
            return doesCircleExist(path, pos + 1, p, angle, visited);
        else
            return doesCircleExist(path, pos + 1, start, angle, visited);
    }

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }


    //Question 4
    public void SuperStack (String[] operations) {
        int[] s = new int[operations.length];
        for(int i = 0; i < operations.length; i++) {
            s[i] = Integer.MIN_VALUE;
        }

        int index = 0;
        for(String str : operations) {
            String[] subStr = str.split(" ");
            switch (subStr[0]) {
                case "push":
                    index++;
                    s[index] = Integer.parseInt(subStr[1]);
                    System.out.println(s[index]);
                    break;
                case "pop":
                    s[index] = Integer.MIN_VALUE;
                    if(index > 1) {
                        System.out.println(s[index]);
                        index--;
                    } else {
                        System.out.println("EMPTY");
                        if(index == 1)
                            index--;
                    }
                    break;
                case "inc":
                    int i = Integer.parseInt(subStr[1]) - 1;
                    int value = Integer.parseInt(subStr[2]);
                    while(i >= 0) {
                        if(s[i] != Integer.MIN_VALUE) {
                            s[i] += value;
                        }
                        i--;
                    }

                    System.out.println(s[index]);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        IndeedTest kp = new IndeedTest();

        String commands = "GGRGGRGGGRGG";

        System.out.println(kp.doesCircleExist(commands));
    }

}
