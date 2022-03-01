package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/longest-increasing-subsequence/

 */
public class S300 {
    public  static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp[0] = 1;
            }else if(nums[i]>nums[i-1]){
                dp[i] =  dp[i-1]+1;
            }else{
                dp[i] = dp[i-1];
            }
        }
        System.err.println(Arrays.toString(dp));
        return dp[length-1];
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
