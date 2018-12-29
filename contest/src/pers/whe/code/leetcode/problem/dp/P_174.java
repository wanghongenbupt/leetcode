package pers.whe.code.leetcode.problem.dp;

public class P_174 {

    /*
    * 174. Dungeon Game
    * 状态 dp[i][j] 表示从第i，j个位置救到公主最少用的健康值。
    * 转移方程  dp[i][j] = Math.min(1, dp[i-1][j] - num[i][j], dp[i][j - 1] - num[i][j])
    * 初始态   dp[m-1][n-1] = Math.max(1, 1 - num[i][j]);
    * 结果 dp[0][0]
     * */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j+ 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.min(Math.max(1, dp[i+1][j] - dungeon[i][j]), Math.max(1, dp[i][j+1] - dungeon[i][j]));
                }
            }
        }
        return dp[0][0];
    }
}
