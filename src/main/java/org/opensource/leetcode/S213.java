package org.opensource.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/

 */
public class S213 {
    public  static int rob(int[] nums) {
        int length = nums.length;
        int[] dp1 = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp1[0] = nums[0];
            }else if(i==1){
                dp1[1] = Math.max(nums[0],nums[1]);
            } else if (i == length - 1) {
                dp1[i] = dp1[i-1];
            }else{
                dp1[i] = Math.max(nums[i]+dp1[i-2], dp1[i-1]);
            }
        }
        int[] dp2 = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==0){
                dp2[0] = 0;
            }else if(i==1){
                dp2[1] = Math.max(dp2[0],nums[1]);
            }else{
                dp2[i] = Math.max(nums[i]+dp2[i-2], dp2[i-1]);
            }
        }
        return Math.max(dp1[length-1],dp2[length-1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
