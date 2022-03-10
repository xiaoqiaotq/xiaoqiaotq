package org.opensource.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class S996 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        S996 solution = new S996();
//        System.out.println(solution.numSquarefulPerms(new int[]{1, 2, 1}));
//        System.out.println(solution.numSquarefulPerms(new int[]{1,17,8}));
        System.out.println(solution.numSquarefulPerms(new int[]{2,2,2}));
    }
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];

        backtrack(nums,used);
        System.err.println(result);
        return result.size();
    }

    /**
     */
    private void backtrack(int[] arr,boolean[] used){
        //终止条件
        if (path.size() == arr.length){
            result.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = 0; i < arr.length ; i++){
            if (used[i] || ( i>0 &&!used[i-1] && arr[i]==arr[i-1])  ) {
                continue;
            }
            if((!path.isEmpty() && !isSquare(arr[i]+path.getLast()))){
                continue;
            }
            used[i] = true;
            path.add(arr[i]);
            backtrack(arr ,used);
            used[i] = false;
            path.removeLast();
        }
    }

    public boolean isSquare(int num){
        double a=0;
        a = Math.sqrt(num);
        int b =(int)a;
        return a - b == 0;
    }
}