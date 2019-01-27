package pers.whe.code.leetcode.context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Context121 {
    public String strWithout3a3b(int a, int b) {
        char[] res = new char[a + b];
        for (int i = 0; i < res.length; i++) {
            if (i >= 2 && res[i - 1] == res[i - 2]) {
                if (res[i - 1] == 'a') {
                    res[i] = 'b';
                    b--;
                } else {
                    res[i] = 'a';
                    a--;
                }
            } else {
                if (a > b) {
                    res[i] = 'a';
                    a--;
                } else {
                    res[i] = 'b';
                    b--;
                }
            }
        }
        return new String(res);
    }

    /*
     * dp[i] 以i为结尾的所花费钱数
     * */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i : days) {
            dp[i] = 1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == Integer.MIN_VALUE) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + costs[0];
            }
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
            }
            if (i >= 30) {
                dp[i] = Math.min(dp[i], Math.min(dp[i - 7] + costs[1], dp[i - 30] + costs[2]));
            }
        }
        return dp[365];
    }


    public static void main(String[] args) {
        new Context121().strWithout3a3b(1, 2);
    }

    public int countTriplets(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int tmp = A[i] & A[j];
                for (int k = j; k < A.length; k++) {
                    int re = tmp & A[k];
                    if (re == 0) {
                        if (i == j && j == k) {
                            count += 1;
                        } else if (i == j || i == k || j == k) {
                            count += 3;
                        } else {
                            count += 6;
                        }
                    }
                }
            }
        }

        return count;
    }
}

class TimeMap {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tree = map.get(key);
        if (tree == null) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tree = map.get(key);
        if (tree == null) {
            return "";
        }
        Integer pre = tree.floorKey(timestamp);
        if (pre == null) return "";
        return tree.get(pre);
    }
}