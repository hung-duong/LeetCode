package edu.mum.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/16/17.
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        for(int i = rows - 2; i >= 0; i--) {
            int cols = triangle.get(i).size();
            for(int j = 0; j < cols; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
