package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 10/13/16.
 */
public class UniquePaths {
    //Solution 1: Recursion -> Bad
    static int numPaths = 0;

    public static int uniquePaths1(int m, int n) {

        uniquePathsHelper(m, n, 1, n);

        return numPaths;
    }

    public static void uniquePathsHelper(int m, int n, int posX, int posY) {
        if(posX == m && posY == 1) {
            numPaths++;
        } else {
            if(posX < m)
                uniquePathsHelper(m, n, posX + 1, posY);

            if(posY > 1)
                uniquePathsHelper(m, n, posX, posY - 1);
        }
    }

    //Solution 2: -> Best (Using Dynamic Programming)
    //1-1 -> 1 		Q(1, 1) = 1
    //1-2 ->1 		Q(1, 2) = 1
    //1-3 ->1 		Q(1, 3) = 1
    //1-4->1  		Q(1, 4) = 1
    //
    //2-1->1   		Q(2, 1) = 1
    //2-2->2  		Q(2, 2) = 2
    //2-3->3  		Q(2, 3) = 3
    //2-4->4  		Q(2, 4) = 4
    //2-5->5  		Q(2, 5) = 5
    //2-6->6  		Q(2, 6) = 6
    //
    //3-1-> 1  		Q(3, 1) = 1
    //3-2-> 3 		Q(3, 2) = 3
    //3-3-> 6 		Q(3, 3) = 6
    //3-4-> 10 	    Q(3, 4) = 10
    //3-5-> 15  	Q(3, 5) = 15
    //3-6-> 21  	Q(3, 6) = 21
    //3-7 -> 28  	Q(3, 7) = 28
    //
    //4-1-> 1  		Q(4, 1) = 1
    //4-2-> 4  	    Q(4, 2) = 4
    //4-3-> 10  	Q(4, 3) = 10
    //4-4->20  	    Q(4, 4) = 20
    //4-5-> 35  	Q(4, 5) = 35
    //4-6-> 56  	Q(4, 6) = 56

    public static int uniquePaths2(int m, int n) {

        int[] Q = new int[n];

        for(int i = 0; i < n; i++) {
            Q[i] = 1;
        }

        for(int i=1; i < m; i++) {
            for(int j=1; j < n; j++) {
                Q[j] = Q[j] + Q[j - 1];
            }
        }


        return Q[n - 1];
    }

    public static void main(String[] args) {
        System.out.print(UniquePaths.uniquePaths2(3,4));
    }
}
