package pers.whe.code.leetcode.problem.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1001 {

    /*
     * 1001. Grid Illumination
     * */
    Map<Integer, Integer> rowCount = new HashMap<>();
    Map<Integer, Integer> colCount = new HashMap<>();
    Map<Integer, Integer> x_yCount = new HashMap<>();
    Map<Integer, Integer> xsyCount = new HashMap<>();
    int[] dx = new int[]{0, 0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = new int[]{0, 1, -1, 0, 0, -1, 1, -1, 1};
    Set<Integer> lam = new HashSet<>();

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        for (int[] lamp : lamps) {
            addLamp(lamp[0], lamp[1], 1);
            lam.add(lamp[0] * N + lamp[1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (rowCount.getOrDefault(x, 0) > 0 || colCount.getOrDefault(y, 0) > 0 ||
                    x_yCount.getOrDefault(x + y, 0) > 0 || xsyCount.getOrDefault(x - y, 0) > 0) {
                res[i] = 1;
            }
            for (int j = 0; j < dx.length; j++) {
                int nx = x + dx[j], ny = y + dy[j];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (lam.contains(nx * N + ny)) {
                        lam.remove(nx * N + ny);
                        addLamp(nx, ny, -1);
                    }
                }
            }
        }
        return res;
    }

    private void addLamp(int x, int y, int val) {
        rowCount.put(x, rowCount.getOrDefault(x, 0) + val);
        colCount.put(y, colCount.getOrDefault(y, 0) + val);
        x_yCount.put(x + y, x_yCount.getOrDefault(x + y, 0) + val);
        xsyCount.put(x - y, xsyCount.getOrDefault(x - y, 0) + val);
    }
}
