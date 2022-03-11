package org.opensource.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
。

 */
public class S989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        BigInteger a = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;
        for (int i = num.length-1; i >=0; i--) {
            BigInteger pow = ten.pow(num.length-i-1);
            a=a.add(pow.multiply(BigInteger.valueOf(num[i])));
        }
        BigInteger sum = a.add(BigInteger.valueOf(k));
        while (!sum.equals(BigInteger.ZERO)){
            BigInteger i = sum.mod(ten);
            sum = sum.divide(ten);
            result.add(0,i.intValue());
        }
        System.err.println(a);
        return result;

    }


    public static void main(String[] args) {
        S989 s = new S989();
//        System.out.println(s.addToArrayForm(new int[]{1,2,3,4},10));
        System.out.println(s.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
        System.out.println(s.addToArrayForm(new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3},516));
    }
}
