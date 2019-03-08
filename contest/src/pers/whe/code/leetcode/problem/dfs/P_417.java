package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.List;

public class P_417 {

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1,-1,  0, 0};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        boolean[][] fic = new boolean[m][n], tic = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(matrix, fic, 0, i);
            dfs(matrix, tic, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, fic, i, 0);
            dfs(matrix, tic, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (fic[i][j] && tic[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    private void dfs(int[][] matrix, boolean[][] tic, int i, int j) {
        tic[i][j] = true;
        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length
                    && !tic[nx][ny] && matrix[i][j] <= matrix[nx][ny]) {
                dfs(matrix, tic, nx, ny);
            }
        }
    }
}
