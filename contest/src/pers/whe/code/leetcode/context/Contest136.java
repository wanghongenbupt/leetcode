package pers.whe.code.leetcode.context;

import java.util.*;

public class Contest136 {

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, i = 0;
        int[][] d = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                i = (i + 1) % 4;
            } else if (c == 'L') {
                i = (i + 3) % 4;
            } else {
                x += d[i][0]; y += d[i][1];
            }
        }
        return x == 0 && y == 0 || i > 0;
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }
        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
            for(Integer integer:map.get(i)){
                Object type = res[integer-1];
                list.remove(type);
            }
            res[i - 1] = list.get(0);
        }
        return res;
    }

    public int maxSumAfterPartitioning(int[] a, int K) {
        int[] dp = new  int[a.length];
        for (int i = 0; i < a.length; i++) {
            int max = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; k++) {
                max = Math.max(max, a[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + max * k);
            }
        }
        return dp[a.length - 1];
    }
}
