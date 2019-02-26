package pers.whe.code.leetcode.problem.sort;

import java.util.Arrays;

public class P_475 {

    /*
     * 475. Heaters
     * */
    public int findRadius(int[] houses, int[] heaters) {
        int res = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -index - 1;
            }
            int l = index <= 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
            int r = index >= heaters.length ? Integer.MAX_VALUE : heaters[index] - house;
            res = Math.max(res, Math.min(l, r));
        }
        return res;
    }
}
