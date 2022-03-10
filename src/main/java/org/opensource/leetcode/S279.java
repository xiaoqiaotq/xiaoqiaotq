package org.opensource.leetcode;

/**
 https://leetcode-cn.com/problems/perfect-squares/
。

 */
public class S279 {
    public  int numSquares(int n) {
        int length = n + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (isSquare(i)) {
                dp[i] = 1;
            }
            for (int j = 1; j < i/2+1; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public boolean isSquare(int num){
        double a=0;
        a = Math.sqrt(num);
        int b =(int)a;
        return a - b == 0;
    }

    public static void main(String[] args) {
        S279 s279 = new S279();
        System.out.println(s279.numSquares(12));
        System.out.println(s279.numSquares(13));
    }
}
