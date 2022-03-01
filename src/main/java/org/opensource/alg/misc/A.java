package org.opensource.alg.misc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A {
    public int missingNumber(int[] nums) {
        int sum = IntStream.range(0, nums.length).sum();
        int sum1 = IntStream.of(nums).sum();

        Integer a=122;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += ( a >> i ) & 1;
        }
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==i+1) {

            }
        }
        return result;
    }

    public char findTheDifference(String s, String t) {
        int result=0;
        for (char aChar : s.toCharArray()) {
            result  ^= aChar;
        }
        for (char aChar : t.toCharArray()) {
            result  ^= aChar;
        }
       return (char) result;
    }
    public boolean isUnique(String astr) {
        int result=0;
        for (char aChar : astr.toCharArray()) {
            result  ^= aChar;
        }
        return result != 0;
    }

}
