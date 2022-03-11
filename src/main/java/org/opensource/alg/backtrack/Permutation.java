package org.opensource.alg.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used=new boolean[100];

    public static void main(String[] args) {
        Permutation solution = new Permutation();

//        System.out.println(solution.permuteUnique(new int[]{1, 2, 3}));
//        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(solution.permuteUnique(new int[]{1, 2, 1}));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    /**
     */
    private void backtrack(int[] arr){
        //终止条件
        if (path.size() == arr.length){
            result.add(new ArrayList<>(path));
            return;
        }
//        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        for (int i = 0; i < arr.length ; i++){
            if (used[i] || ( i>0 &&!used[i-1] && arr[i]==arr[i-1])) {
                continue;
            }
            used[i] = true;
            path.add(arr[i]);
            backtrack(arr );
            used[i] = false;
            path.removeLast();
        }
    }
}