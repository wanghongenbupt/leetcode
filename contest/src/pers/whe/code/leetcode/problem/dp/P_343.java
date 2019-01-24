package pers.whe.code.leetcode.problem.dp;

public class P_343 {

    /*
    * 343. Integer Break
    * 状态 dp[i] 对i分解能得到的最大值
    * 转移方程 dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
    * i 可能大于 dp[i] 所以 Math.max(j, dp[j] 如 2 > dp[2] = 1;
     * */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
