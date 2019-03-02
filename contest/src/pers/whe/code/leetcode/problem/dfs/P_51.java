package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.List;

public class P_51 {


    /*
     * 51. N-Queens
     * */
    List<List<String>> res = new ArrayList<>();
    int lineCount = 0;

    public List<List<String>> solveNQueens(int n) {
        lineCount = n;
        dfs(0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int i, ArrayList<Integer> item) {
        if (i == lineCount) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < lineCount; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < lineCount; k++) {
                    if (item.get(j) == k) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                cur.add(sb.toString());
            }
            res.add(cur);
            return;
        }
        for (int j = 0; j < lineCount; j++) {
            if (isOK(i, j, item)) {
                item.add(j);
                dfs(i + 1, item);
                item.remove(item.size() - 1);
            }
        }
    }

    private boolean isOK(int i, int j, ArrayList<Integer> item) {
        for (int k = 0; k < i; k++) {
            if (item.get(k) == j) return false;
            if (k + item.get(k) == i + j) return false;
            if (k - item.get(k) == i - j) return false;
        }
        return true;
    }
}
