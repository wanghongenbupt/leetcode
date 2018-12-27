package pers.whe.code.leetcode.problem.dfs;

public class P_959 {

    /*
     * 959. Regions Cut By Slashes
     *  \          /
     *  100      001
     *  010      010
     *  001      100
     * */
    public int regionsBySlashes(String[] g) {
        int n = g.length;
        int[][] p = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i * 3, y = j * 3;
                if (g[i].charAt(j) == '/') {
                    p[x][y + 2] = p[x + 1][y + 1] = p[x + 2][y] = 1;
                }
                if (g[i].charAt(j) == '\\') {
                    p[x][y] = p[x + 1][y + 1] = p[x + 2][y + 2] = 1;
                }
            }
        }
        int c = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (p[i][j] == 0) {
                    c++;
                    dfs(i, j, p);
                }
            }
        }
        return c;
    }

    private void dfs(int i, int j, int[][] p) {
        if (i < 0 || i >= p.length || j < 0 || j >= p.length || p[i][j] == 1) return;
        p[i][j] = 1;
        dfs(i - 1, j, p);
        dfs(i, j - 1, p);
        dfs(i, j + 1, p);
        dfs(i + 1, j, p);
    }
}
