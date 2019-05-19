package pers.whe.code.leetcode.problem.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_576 {

    /*
     * 576. Out of Boundary Paths
     * map表示从i j 还剩N步 到边界外的数量
     * */
    int mod = (int)1e9 + 7;
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    Map<String, Integer> map = new HashMap<>();
    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m, n, i, j, N);
    }

    private int dfs(int m, int n, int i, int j, int N) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (N == 0) return 0;
        String str = Arrays.toString(new int[]{i, j, N});
        if (map.containsKey(str)) return map.get(str);
        int res = 0;
        N--;
        for (int k = 0; k < dx.length; k++) {
            res = (res + dfs(m, n, i + dx[k], j + dy[k], N)) % mod;
        }
        map.put(str, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{1, 3, 4}));
    }
}
