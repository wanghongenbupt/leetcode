package pers.whe.code.leetcode.problem.dp;

import java.util.HashMap;
import java.util.Map;

/*
 * 464. Can I Win
 * */
public class P_464 {
    Map<Integer, Boolean> map = new HashMap<>();
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        used = new boolean[maxChoosableInteger + 1];
        return memorySearch(desiredTotal);
    }

    private boolean memorySearch(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int key = get(used);
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!memorySearch(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);

    }

    private int get(boolean[] used) {
        int res = 0;
        for (boolean cur : used) {
            res <<= 1;
            if (cur) {
                res |= 1;
            }
        }
        return res;
    }
}
