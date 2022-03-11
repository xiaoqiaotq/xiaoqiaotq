package org.opensource.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
。

 */
public class S989_1 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int lastNum =K;
        LinkedList<Integer> ret= new LinkedList<>();

        int i = len-1;
        while(i >=0 || lastNum > 0){
            if(i >= 0){
                lastNum+=A[i];
            }
            ret.addFirst(lastNum%10);
            lastNum/=10;
            i--;
        }

        return ret;
    }
//    public List<Integer> addToArrayForm(int[] num, int k) {
//
//        int kLength = String.valueOf(k).length();
//        int maxLength = Math.max(num.length, kLength);
//        LinkedList<Integer> result = new LinkedList<>();
//
//        int[] numsCopy = new int[maxLength];
//        System.arraycopy(num, 0, numsCopy, maxLength-num.length,
//                num.length);
//
//        int[] kArray = new int[maxLength];
//        int index = maxLength - 1;
//        while (k != 0) {
//            int mod = k % 10;
//            k = k / 10;
//            kArray[index--] = mod;
//        }
//        boolean overflow = false;
//        for (int i = numsCopy.length-1; i >=0; i--) {
//            int sum = 0;
//            if (overflow) {
//                numsCopy[i]++;
//            }
//            sum = numsCopy[i] + kArray[i];
//            if (sum>=10) {
//                overflow = true;
//                sum = sum - 10;
//            }else {
//                overflow = false;
//            }
//            result.addFirst(sum);
//        }
//        if (overflow) {
//            result.addFirst( 1);
//        }
////        System.err.println(Arrays.toString(kArray));
////        System.err.println(result);
//        return result;
//
//    }


    public static void main(String[] args) {
        S989_1 s = new S989_1();
//        System.out.println(s.addToArrayForm(new int[]{1,2,3,4},10));
//        System.out.println(s.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
//        System.out.println(s.addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3},516));
//        System.out.println(s.addToArrayForm(new int[]{0},121));
        System.out.println(s.addToArrayForm(new int[]{1},33));

    }
}
