package pers.whe.code.leetcode.problem.dp;

public class P_375 {

    /*
    * 375. Guess Number Higher or Lower II
    * dp[i][j] 从i到j猜到需要最小pay
    * */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return dfs(dp, 1, n);
    }

    private int dfs(int[][] dp, int l, int r) {
        if (l >= r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int temp = i + Math.max(dfs(dp, l, i - 1), dfs(dp, i + 1, r));
            res = Math.min(res, temp);
        }
        return res;
    }
}
