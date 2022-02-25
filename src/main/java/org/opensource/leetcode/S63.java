package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class S63 {
    public  static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else {
                    if (i == 0 && j==0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] != 0 ? 1 : 0;
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] != 0 ? 1 : 0;
                    }else {
                        dp[i][j] = dp[i][j - 1] +dp[i - 1][j];
                    }
                }

            }

        }
        for (int i = 0; i < m; i++) {
            System.err.println(Arrays.toString(dp[i]));
        }
//        if(dp[m-1][n-1]==){
//            return 0;
//        }
//        if(dp[m-1][n-1]==0){
//            return 1;
//        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1}, {0,0}, }));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,1,1,0,0,0}, }));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,1,1,0,0,0}, }));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}, }));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}, }));
    }
}
