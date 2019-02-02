package pers.whe.code.leetcode.problem.interval;

import java.util.ArrayList;
import java.util.List;

public class P_699 {

    /*
    * 699. Falling Squares
    * */
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] height = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int cur_l = positions[i][0], cur_r = positions[i][0] + positions[i][1];
            int h = positions[i][1];
            height[i] += h;
            for (int j = i + 1; j < positions.length; j++) {
                int next_l = positions[j][0], next_r = positions[j][0] + positions[j][1];
                if (cur_l >= next_r || cur_r <= next_l) continue;
                height[j] = Math.max(height[j], height[i]);
            }
        }
        int max = 0;
        for (int i : height) {
            max = Math.max(i, max);
            res.add(max);
        }
        return res;
    }
}
