package org.opensource.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/JEj789/
 */
public class S91 {
    public  static int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = costs[i][j]+Math.min(dp[i-1][1] ,dp[i-1][2] );
                }
                if (j == 1) {
                    dp[i][j] = costs[i][j]+Math.min(dp[i-1][0] ,dp[i-1][2] );
                }
                if (j == 2) {
                    dp[i][j] = costs[i][j]+Math.min(dp[i-1][0] ,dp[i-1][1] );
                }
            }
        }

        return Arrays.stream(dp[costs.length-1]).min().orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17}, {16,16,5}, {14,3,19}}));
        System.out.println(minCost(new int[][]{{7,6,2}}));
    }
}
