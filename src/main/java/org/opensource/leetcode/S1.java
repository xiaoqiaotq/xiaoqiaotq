package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/two-sum/
 */
public class S1 {
    public  static int[] twoSum(int[] nums, int target) {
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{7,8,1},3)));
        System.out.println(Arrays.toString(twoSum(new int[]{7,8,1},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{7,8,1},15)));
        System.out.println(Arrays.toString(twoSum(new int[]{7,8,1},16)));
        System.out.println(Arrays.toString(twoSum(new int[]{7,8,1},17)));
    }
}
