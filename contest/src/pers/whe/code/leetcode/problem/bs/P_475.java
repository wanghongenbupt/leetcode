package pers.whe.code.leetcode.problem.bs;

import java.util.Arrays;

public class P_475 {
    public int findRadius(int[] houses, int[] heaters) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int h : houses) {
            int i = Arrays.binarySearch(heaters, h);
            if (i < 0) {
                i = -i - 1;
            }
            int l = i <= 0 ? Integer.MAX_VALUE : h - heaters[i - 1];
            int r = i >= heaters.length ? Integer.MAX_VALUE : heaters[i] - h;
            res = Math.max(res, Math.min(l,r));
        }
        return res;
    }
}
