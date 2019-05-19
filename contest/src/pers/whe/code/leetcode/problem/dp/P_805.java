package pers.whe.code.leetcode.problem.dp;

import java.util.Arrays;

public class P_805 {

    public boolean splitArraySameAverage(int[] a) {
        int n = a.length, sum = Arrays.stream(a).sum();
        Arrays.sort(a);
        for (int i = 1; i <= n / 2; i++) {
            if ((sum * i) % n == 0)
                if(find(a, sum * i / n, i, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean find(int[] a, int t, int k, int i) {
        if (k == 0) return t == 0;
        if (a[i] > t / k) return false;
        for (int j = i; j < a.length - k + 1; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            if (find(a, t - a[i], k - 1, j + 1)) {
                return true;
            }
        }
        return false;
    }
}
