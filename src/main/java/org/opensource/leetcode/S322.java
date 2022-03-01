package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/coin-change-2/
 */
public class S322 {
    public  static int coinChange(int amount,int[] coins) {
        int m = coins.length;
        int n = amount + 1;
        int[][] dp = new int[m][n];
//        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (i % coins[0] ==0) {
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = Integer.MAX_VALUE;

            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j>=coins[i]) {
                    int temp = dp[i][j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i][j - coins[i]] + 1;
                    dp[i][j] = Math.min(temp,dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.err.println(Arrays.toString(dp[i]));
        }
        return dp[m-1][n-1]==Integer.MAX_VALUE?-1:dp[m-1][n-1];

    }

    public static void main(String[] args) {
        System.out.println(coinChange(11,new int[]{1, 2, 5}));
        System.out.println(coinChange(3,new int[]{2}));
        System.out.println(coinChange(0,new int[]{1}));
        System.out.println(coinChange(2,new int[]{1,2}));
        System.out.println(coinChange(27,new int[]{2,5,10,1}));
//        System.out.println(change(3,new int[]{3,2,1}));
//        System.out.println(change(4,new int[]{3,2,1}));
//        System.out.println(change(5,new int[]{3,2,1}));
//        System.out.println(change(6,new int[]{3,2,1}));
//        System.out.println(change(7,new int[]{3,2,1}));
    }
}
