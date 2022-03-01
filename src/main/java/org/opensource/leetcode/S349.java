package org.opensource.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 https://leetcode-cn.com/problems/valid-anagram/
 */
public class S349 {
    public  static int[] intersection(int[] nums1, int[] nums2)  {
        HashSet<Integer> ints = new HashSet(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        ints.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));


        Integer[] integers = ints.toArray(new Integer[]{});

        return  Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,3,4},new int[]{1,3,3})));
        System.out.println(Arrays.toString(intersection(new int[]{2,3,4},new int[]{1,3,3})));
    }
}
