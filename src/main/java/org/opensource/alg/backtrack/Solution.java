package org.opensource.alg.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 3,4};

        System.out.println(solution.combine(arr, 2));
    }
    public List<List<Integer>> combine(int[] arr, int k) {
        combineHelper(arr, k, 0);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int[] arr, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = startIndex; i < arr.length ; i++){
            path.add(arr[i]);
            combineHelper(arr, k, i + 1);
            path.removeLast();
        }
    }
}