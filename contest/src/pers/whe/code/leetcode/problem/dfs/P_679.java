package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.List;

public class P_679 {
    boolean res = false;
    double esp = 0.01;
    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for (int n : nums) arr.add(n + 0.1);
        dfs(arr);
        return res;
    }

    private void dfs(List<Double> arr) {
        if (res) return;
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < esp) {
                res = true;
            }
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> cur = new ArrayList<>();
                double ii = arr.get(i), jj = arr.get(j);
                cur.add(ii + jj);
                cur.add(ii * jj);
                cur.add(ii - jj);
                cur.add(jj - ii);
                if (Math.abs(ii) > esp) {
                    cur.add(jj / ii);
                }
                if (Math.abs(jj) > esp) {
                    cur.add(ii / jj);
                }
                arr.remove(i);
                arr.remove(j);
                for (double d : cur) {
                    arr.add(d);
                    dfs(arr);
                    arr.remove(arr.size() - 1);
                }
                arr.add(j, jj);
                arr.add(i, ii);
            }
        }
    }
}
