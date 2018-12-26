package pers.whe.code.leetcode.context;

import java.util.*;

public class Context103 {
    public int smallestRangeI(int[] a, int k) {
        Arrays.sort(a);
        if (a.length == 1) return 0;
        return Math.max(0, a[a.length - 1] - k - k - a[0]);
    }
}
