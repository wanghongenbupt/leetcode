package pers.whe.code.leetcode.problem.dp;

public class P_664 {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return ms(dp, s, 0, n - 1);
    }

    private int ms(int[][] dp, String s, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != 0) return 0;
        int min = ms(dp, s, l, r - 1) + 1;
        for (int i = l; i < r; i++) {
            if (s.charAt(i) == s.charAt(r)) {
                min = Math.min(min, ms(dp, s, l, i) + ms(dp, s, i + 1, r - 1));
            }
        }
        dp[l][r] = min;
        return min;
    }
}
