package pers.whe.code.leetcode.problem.dp;

import java.util.HashMap;
import java.util.Map;

public class P_1027 {

    /*
    * 1027. Longest Arithmetic Sequence
    * Map<i, Map<j, k>> map 表示 第i个数，
    * 以j为公差，最多连续序列为k
    * */
    public int longestArithSeqLength(int[] a) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            Map<Integer, Integer> map1 = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = a[i] - a[j];
                int cur = map.get(j).containsKey(diff) ? map.get(j).get(diff) + 1 : 1;
                map1.put(diff, cur);
                max = Math.max(max, cur);
            }
            map.put(i, map1);
        }
        return max + 1;
    }
}
