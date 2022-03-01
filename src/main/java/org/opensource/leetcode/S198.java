package org.opensource.leetcode;

/**
 * https://leetcode-cn.com/problems/house-robber/
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
public class S198 {
    public  static int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp[0] = nums[0];
            }else if(i==1){
                dp[1] = Math.max(nums[0],nums[1]);
            }else{
                dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
