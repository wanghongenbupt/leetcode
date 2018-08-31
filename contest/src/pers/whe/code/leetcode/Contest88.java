package pers.whe.code.leetcode;

import jdk.nashorn.internal.runtime.RewriteException;

import java.util.Arrays;
import java.util.TreeSet;

public class Contest88 {

    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char)((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
        }
        return sb.toString();
    }

    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                set.add(i);
            }
        }
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                Integer low = set.lower(i);
                Integer h = set.higher(i);
                if (low != null && h != null) {
                    res = Math.max(res, Math.min(i - low, h - i));
                } else if (low != null) {
                    res = Math.max(res, i - low);
                } else {
                    res = Math.max(res, h - i);
                }
            }

        }
        return res;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[][] graph = new int[quiet.length][quiet.length];
        for (int[] a: richer) {
            graph[a[1]][a[0]] = 1;
        }
        int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < quiet.length; i++) {
            dfs(graph, quiet, res, i);
        }
        return res;
    }

    private int dfs(int[][] graph, int[] quiet, int[] res, int root) {
        if (res[root] != -1) return res[root];
        int index = root;
        for (int i = 0; i < res.length; i++) {
            if (graph[root][i] == 1) {
                int temp = dfs(graph, quiet, res, i);
                if (quiet[temp] < quiet[index]) {
                    index = temp;
                }
            }
        }
        res[root] = index;
        return index;
    }

}
