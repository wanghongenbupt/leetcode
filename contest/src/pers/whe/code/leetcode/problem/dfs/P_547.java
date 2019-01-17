package pers.whe.code.leetcode.problem.dfs;

public class P_547 {

    /*
     * 547. Friend Circles
     * dfs
     * */
    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] see = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!see[i]) {
                res++;
                dfs(i, M, see);
            }
        }
        return res;
    }

    private void dfs(int i, int[][] m, boolean[] see) {
        see[i] = true;
        for (int j = 0; j < see.length; j++) {
            if (!see[j] && m[i][j] == 1) {
                dfs(j, m, see);
            }
        }
    }
}
