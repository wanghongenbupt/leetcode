package pers.whe.code.leetcode.problem.dp;

public class P_983 {

    /*
     * 983. Minimum Cost For Tickets
     * */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for (int i : days) dp[i] = 1;
        dp[0] = 0;
        for (int i = 1; i <= 365; i++) {
            if (dp[i] != 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];
            }
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
            }
            if (i >= 30) {
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[1]);
            }
        }
        return dp[365];
    }
}
