//package org.opensource.alg.misc;
//
//import com.google.common.hash.HashCode;
//import com.google.common.hash.HashFunction;
//import com.google.common.hash.Hashing;
//
//import java.nio.charset.Charset;
//import java.util.Arrays;
//
//public class Murmur3_32HashFunctionTest {
//    public static void main(String[] args) {
//        HashFunction function = Hashing.murmur3_32();
//        HashCode hascode = function.hashString("hello1", Charset.forName("utf-8"));
//        System.out.println(~hascode.asInt());
//        System.out.println(hascode.toString());
//        HashCode hascode2 = function.hashString("hello2", Charset.forName("utf-8"));
//        System.out.println(hascode2.asInt());
//        HashCode hascode3 = function.hashString("hello3", Charset.forName("utf-8"));
//        System.out.println(hascode3.asInt());
//
//        int a=-4;
//        System.err.println(~a);
//        System.err.println(1^1);
//        System.err.println(0^34);
//        System.err.println(1^1^2^3^100);
//        int[] ints = {1, 2, 3, 1, 2};
//        int result=0;
//        for (int anInt : ints) {
//            result ^= anInt;
//        }
//        System.err.println(result);
//
//        int[] intsc = {1, 2, 3, 1, 2,5};
//        int ret = 0;
//        for (int n : intsc) {
//            ret ^= n;
//        }
//        int div = 1;
//        // 找出异或结果中值为 1 的位数是左移第几位
//        while ((div & ret) == 0) {
//            div <<= 1;
//        }
//        int aa=0 ;
//        int bb=0;
//        for (int anInt : intsc) {
//            if ((anInt & div) >0) {
//                aa ^=anInt;
//            }else{
//                bb ^=anInt;
//            }
//        }
//        System.err.println(Arrays.toString(new int[]{aa,bb}));
//
//
//    }
//}