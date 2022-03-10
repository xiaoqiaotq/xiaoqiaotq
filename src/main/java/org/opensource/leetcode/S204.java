package org.opensource.leetcode;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 https://leetcode-cn.com/problems/perfect-squares/
。

 */
public class S204 {
    public  int countPrimes(int n) {
        if (n==1) {
            return 1;
        }

//        return (int) IntStream.range(1, n).filter(i -> BigInteger.valueOf(i).isProbablePrime(100)).count();
        return (int) IntStream.range(2, n).filter(S204::isPrime).count();
    }
    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        S204 s = new S204();
        System.err.println(isPrime(1));
        System.out.println(s.countPrimes(10));
        System.out.println(s.countPrimes(0));
        System.out.println(s.countPrimes(1));
    }
}
