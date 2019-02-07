package pers.whe.code.leetcode.problem.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_850 {
    /*
    * 850. Rectangle Area II
    * */
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][];
        int t = 0;
        for (int[] rect : rectangles) {
            events[t++] = new int[]{rect[1], OPEN, rect[0], rect[2]};
            events[t++] = new int[]{rect[3], CLOSE, rect[0], rect[2]};
        }
        Arrays.sort(events, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> active = new ArrayList<>();
        int cur_y = events[0][0];
        long res = 0;
        for (int[] event : events) {
            int y = event[0], type = event[1], x1 = event[2], x2 = event[3];
            long query = 0;
            int cur = -1;
            for (int[] act : active) {
                cur = Math.max(cur, act[0]);
                query += Math.max(act[1] - cur, 0);
                cur = Math.max(cur, act[1]);
            }
            res += query * (y - cur_y);
            if (type == OPEN) {
                active.add(new int[]{x1, x2});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int i = 0; i < active.size(); i++) {
                    if (active.get(i)[0] == x1 && active.get(i)[1] == x2) {
                        active.remove(i);
                        break;
                    }
                }
            }
            cur_y = y;
        }
        res %= 1_000_000_007;
        return (int)res;
    }
}
