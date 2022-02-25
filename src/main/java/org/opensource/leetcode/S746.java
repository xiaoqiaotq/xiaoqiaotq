package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 输入：[1,2,3,1]
 输出：4
 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 输入：[2,7,9,3,1]
 输出：12
 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
      偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 */
public class S746 {
    public  static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp[0] = cost[0];
            }else if(i==1){
                dp[1] = cost[1];
            }else{
                dp[i] = cost[i]+Math.min(dp[i-2], dp[i-1]);
            }
        }
        System.err.println(Arrays.toString(dp));
        return Math.min(dp[length-1],dp[length-2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
