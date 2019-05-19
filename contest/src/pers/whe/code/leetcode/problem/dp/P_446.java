package pers.whe.code.leetcode.problem.dp;

import java.util.HashMap;
import java.util.Map;

public class P_446 {

    /*
    * Map[k]<i,j> 表示以第k个数结尾的，公差为i的有j - 1个
     * */
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, Integer>[] maps = new Map[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long)A[i] - A[j];
                if (d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) continue;
                int diff = (int)d;
                int cj = maps[j].getOrDefault(diff, 0);
                int ci = maps[i].getOrDefault(diff, 0);
                res += cj;
                maps[i].put(diff, ci + cj + 1);
            }
        }
        return res;
    }
}
