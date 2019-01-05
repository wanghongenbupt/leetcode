package pers.whe.code.leetcode.problem.math;

public class P_829 {
    /*
     * 829. Consecutive Numbers Sum
     * 首项 x, 项数m  和 (x + x + m - 1) * m / 2 = N;
     * mx + m(m-1)/2 = N
     * */
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int m = 1; ; m++) {
            int mx = N - (m - 1) * m / 2;
            if (mx <= 0) break;
            if (mx % m == 0) count++;
        }
        return count;
    }
}
