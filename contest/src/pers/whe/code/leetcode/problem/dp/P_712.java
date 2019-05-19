package pers.whe.code.leetcode.problem.dp;

public class P_712 {

    /*
    * 712. Minimum ASCII Delete Sum for Two Strings
    * dp[i][j] s1的第i个字符和s2的第j个字符匹配需要的最小delete
    * */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1);
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }
                }
            }
        }
        return dp[m][n];
    }
}
