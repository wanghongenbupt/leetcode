package pers.whe.code.leetcode.problem.dp;

import java.util.Arrays;

public class P_322 {

    /*
    *322. Coin Change
    * dp[i] 拿到i少使用
     * */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }


    /*
    * 518. Coin Change 2
    * dp[i][j] 前i个是否能组成j
    * */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i] ? dp[i][j - coins[i]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
