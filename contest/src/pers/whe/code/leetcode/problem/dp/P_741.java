package pers.whe.code.leetcode.problem.dp;

import java.util.Arrays;

public class P_741 {

    /*
     * 741. Cherry Pickup
     * 题目分解为两人从右下向左上走，
     * dp[r1][c1][r2] 表示第一个人在 r1,c1
     * 第二个人在 r2,c2=r1+c1-r2上位置所得的最多樱桃数。
     * */
    int[][][] dp;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        dp = new int[grid.length][grid[0].length][grid.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, bestPath(0, 0, 0));
    }

    private int bestPath(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= grid.length || r2 >= grid.length || c1 > grid[0].length || c2 > grid[0].length) return -1;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return -1;
        if (dp[r1][c1][r2] != Integer.MIN_VALUE) return dp[r1][c1][r2];
        if (r1 == grid[0].length - 1 && c1 == grid[0].length) return grid[r1][c1];
        dp[r1][c1][r2] = Math.max(Math.max(bestPath(r1 + 1, c1, r2 + 1),
                bestPath(r1, c1 + 1, r2 + 1)),
                Math.max(bestPath(r1 + 1, c1, r2), bestPath(r1, c1 + 1, r2)));
        if (dp[r1][c1][r2] < 0) return dp[r1][c1][r2] = -1;
        dp[r1][c1][r2] += grid[r1][c1];
        if (r1 != r2) dp[r1][c1][r2] += grid[r2][c2];
        return dp[r1][c1][r2] += grid[r1][c1];
    }
}
