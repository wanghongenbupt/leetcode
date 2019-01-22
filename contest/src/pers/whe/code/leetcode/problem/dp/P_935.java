package pers.whe.code.leetcode.problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_935 {

    /*
    * 935. Knight Dialer
    * 找到能到达当前节点的来源，并把他们加起来
    * */
    public int knightDialer(int N) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(4,6));
        lists.add(Arrays.asList(6,8));
        lists.add(Arrays.asList(7,9));
        lists.add(Arrays.asList(4,8));
        lists.add(Arrays.asList(3,9,0));
        lists.add(new ArrayList<>());
        lists.add(Arrays.asList(1,7,0));
        lists.add(Arrays.asList(2,6));
        lists.add(Arrays.asList(1,3));
        lists.add(Arrays.asList(2,4));

        long mod = 1000000007;
        long dp[] = new long[10];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= N; i++) {
            long cur[] = new long[10];
            for (int j = 0; j < 10; j++) {
                for (int k : lists.get(j)) {
                    cur[j] = (cur[j] + dp[k]) % mod;
                }
            }
            dp = cur;
        }
        long res = 0;
        for (long i: dp) {
            res = (res + i) % mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        new P_935().knightDialer(2);
    }
}
