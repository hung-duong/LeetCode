package edu.mum.hard.topologicalsort;

/**
 * Created by hungduong on 11/2/16.
 */
public class LongestIncreasingPathInAMatrix {
    public static final int[][] paths = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //Use DFS
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] tracker = new int[m][n];

        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, tracker);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] tracker) {
        //If calculating before do not need to do again
        if(tracker[i][j] > 0) return tracker[i][j];

        int max = 1;

        for(int[] path : paths) {
            int x = i + path[0], y = j + path[1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;

            int len = 1 + dfs(matrix, x, y, tracker);
            max = Math.max(max, len);
        }

        tracker[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
            };

        System.out.print(longestIncreasingPath(nums));
    }

}
