package pers.whe.code.leetcode.problem.dp;

public class P_115 {

    /*
    * 115. Distinct Subsequences
    * dp[i][j] s的前i个字符和t的前j个字符匹配的个数
    * */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[m][n];
    }
}
