package org.opensource.leetcode;

import com.sun.org.omg.CORBA.ContextIdSeqHelper;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/coin-change-2/
 */
public class S518 {
    public  static int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount + 1;
        int[][] dp = new int[m][n];
//        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            // ，完全不需要任何货币，即一种方法，初始化为1
            dp[i][0] = 1;
//            dp[i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if (i % coins[0] ==0) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j>=coins[i]) {
                    dp[i][j] = dp[i][j - coins[i]] +dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.err.println(Arrays.toString(dp[i]));
        }
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1, 2, 5}));
        System.out.println(change(3,new int[]{2}));
        System.out.println(change(10,new int[]{10}));
        System.out.println(change(0,new int[]{7}));
//        System.out.println(change(3,new int[]{3,2,1}));
//        System.out.println(change(4,new int[]{3,2,1}));
//        System.out.println(change(5,new int[]{3,2,1}));
//        System.out.println(change(6,new int[]{3,2,1}));
//        System.out.println(change(7,new int[]{3,2,1}));
    }
}
