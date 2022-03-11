package org.opensource.leetcode;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/two-sum/
 */
public class S389 {
    public  static char findTheDifference(String s, String t) {
        char r = 0;

        for (int i = 0; i < s.toCharArray().length; i++) {
            r ^= s.charAt(i);
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            r ^= t.charAt(i);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("cccd","dccca"));
    }
}
