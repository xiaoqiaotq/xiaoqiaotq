package org.opensource.leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class S64 {
    public  static int minPathSum(int[][] grid) {
        int[] ints = new int[3];
        int[][] ints3 = new int[3][5];
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }else if (j - 1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }else if (i - 1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {4, 2, 1}, {4, 2, 1}}));
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
