package org.opensource.alg.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    int sum = 0;


    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] arr = new int[]{10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(solution.combinationSum(arr, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return result;
    }

    private void backTrack(int[] arr, int target, int startIndex){
        //终止条件
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target){
            return;
        }
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = startIndex; i < arr.length ; i++){
            if (i > startIndex && arr[i] == arr[i - 1]) {
                continue;
            }
            sum += arr[i];
            path.add(arr[i]);
            backTrack(arr, target, i+1);
            sum -= arr[i];
            path.removeLast();
        }
    }
}