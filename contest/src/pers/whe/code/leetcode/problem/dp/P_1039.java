package pers.whe.code.leetcode.problem.dp;

public class P_1039 {


    /*
    * 1039. Minimum Score Triangulation of Polygon
    * dp[i][j] 从第i到第j个点组成三角形最小score
    * */
    public int minScoreTriangulation(int[] a) {
        int[][] dp = new int[a.length][a.length];
        return ms(a, dp, 0, a.length - 1);
    }

    private int ms(int[] a, int[][] dp, int l, int r) {
        if (l + 1 >= r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        dp[l][r] = Integer.MAX_VALUE;
        for (int k = l + 1; k < r; k++) {
            dp[l][r] = Math.min(dp[l][r], a[l] * a[k] * a[r]
            + ms(a, dp, l, k) + ms(a, dp, k, r));
        }
        return dp[l][r];
    }
}