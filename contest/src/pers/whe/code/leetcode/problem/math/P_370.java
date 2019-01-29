package pers.whe.code.leetcode.problem.math;

public class P_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int s = updates[i][0], e = updates[i][1], n = updates[i][2];
            res[s] += n;
            while (e + 1 < updates.length) {
                res[e + 1] -= n;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}