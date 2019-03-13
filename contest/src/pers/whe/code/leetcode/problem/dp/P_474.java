package pers.whe.code.leetcode.problem.dp;

public class P_474 {

    /*
    * dp[i][j][k] 前i个字符串，j0,i,1最大多少
    * */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < strs.length + 1; i++) {
            int[] cc = new int[]{0, 0};
            if (i > 0) {
                cc = cal(strs[i - 1]);
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j >= cc[0] && k >= cc[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cc[0]][k - cc[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] cal(String str) {
        int[] cc = new int[]{0, 0};
        for (char c : str.toCharArray()) {
            if (c == '0') cc[0]++;
            else if (c == '1') cc[1]++;
        }
        return cc;
    }
}
