package pers.whe.code.leetcode.problem.dp;

public class P_740 {

    public int deleteAndEarn(int[] nums) {
        int[] num = new int[10001];
        for (int n : nums) {
            num[n] += n;
        }
        int t = 0, s = 0;
        for (int i = 0; i <= 10000; i++) {
            int ti = s + num[i];
            int si = Math.max(s, t);
            t = ti; s = si;
        }
        return Math.max(t, s);
    }
}
