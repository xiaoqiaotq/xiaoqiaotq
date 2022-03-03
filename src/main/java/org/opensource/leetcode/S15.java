package org.opensource.leetcode;

import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

/**
 https://leetcode-cn.com/problems/3sum/
 */
public class S15 {
    public  static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        int m = nums.length;
        Arrays.sort(nums);
        System.err.println(Arrays.toString(nums));

        List<List<Integer>>  result = new ArrayList<>();
        if (m>=3) {
            for (int i = 0; i < m-2 && nums[i]<=0; i++) {
//                for (int j = i+1; j < m-1; j++) {
//                    for (int k = j+1; k < m; k++) {
//                        if(nums[i]+nums[j]+nums[k]==target){
//                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                        }
//                    }
//                }
                int j=i+1,k=m-1;
                if(nums[0]==0){
                    if (target-nums[i]==nums[j]+nums[k]) {
                        result.add(Arrays.asList(0, 0, 0));
                    }
                    break;
                }
                // 正确去重方法
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while (j<k){

                    if (target-nums[i]==nums[j]+nums[k]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j+1<k && nums[j+1]==nums[j]) {
                            j++;
                        }
                        j++;
                        k--;
                    }else if(target-nums[i]<nums[j]+nums[k]){
                        k--;
                    }else {
                        j++;
                    }
                }

            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println((threeSum(new int[]{-1,0,1,2,-1,-4})));
        System.out.println((threeSum(new int[]{})));
        System.out.println((threeSum(new int[]{0})));
        System.out.println((threeSum(new int[]{3,0,-2,-1,1,2})));
        System.out.println((threeSum(new int[]{0,0,0,0})));
        System.out.println((threeSum(new int[]{0,1,1})));
        System.out.println((threeSum(new int[]{3,0,-2,-1,1,2})));
        System.out.println((threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6})));
    }
}
