package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/longest-increasing-subsequence/

 */
public class S300 {
    public  static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.err.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
