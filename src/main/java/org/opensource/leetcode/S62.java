package org.opensource.leetcode;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class S62 {
    public  static int uniquePath(int m,int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i][j - 1] +dp[i - 1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePath(7,3));
        System.out.println(uniquePath(3,3));
    }
}
