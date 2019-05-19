package pers.whe.code.leetcode.problem.dp;

import java.util.HashMap;
import java.util.Map;

public class P_691 {


    public int minStickers(String[] arr, String tar) {
        int n = arr.length;
        int[][] count = new int[n][26];
        for (int i = 0; i < arr.length; i++) {
            for (char c : arr[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("", 0);
        return ms(count, map, tar);
    }

    private int ms(int[][] count, Map<String, Integer> map, String tar) {
        if (map.containsKey(tar)) return map.get(tar);
        int res = Integer.MAX_VALUE, n = count.length;
        int[] tarCount = new int[26];
        for (char c : tar.toCharArray()) tarCount[c - 'a']++;
        for (int[] cur : count) {
            if (cur[tar.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.max(0, tarCount[i] - cur[i]); i++) {
                sb.append((char)('a' + i));
            }
            int next = ms(count, map, sb.toString());
            if (next != -1 && next + 1 < res) {
                res = next + 1;
            }
        }
        map.put(tar, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(tar);
    }
}
