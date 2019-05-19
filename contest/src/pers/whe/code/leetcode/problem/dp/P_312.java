package pers.whe.code.leetcode.problem.dp;

public class P_312 {

    /*
    * dp[i][j] 爆破i到j内气球所用最小coins
    * */
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[][] dp = new int[n][n];
        int[] nn = new int[n];
        nn[0] = nn[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            nn[i] = nums[i - 1];
        }
        return dfs(0, n - 1, dp, nn);
    }

    private int dfs(int l, int r, int[][] dp, int[] nn) {
        if (dp[l][r] != 0) return dp[l][r];
        if (l + 1 >= r) return 0;
        else if (l + 2 == r) {
            dp[l][r] = nn[l] * nn[l + 1] * nn[r];
        } else {
            for (int k = l + 1; k < r; k++) {
                dp[l][r] = Math.min(dp[l][r], nn[l] * nn[k] * nn[r] +
                        dfs(l, k, dp, nn) + dfs(k, r, dp, nn));
            }
        }
        return dp[l][r];
    }
}
