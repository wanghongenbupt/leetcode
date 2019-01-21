package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.List;

public class P_77 {

    /*
    *77. Combinations
    * dfs 定义，以item内元素为开始寻找下一个元素
    * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int n, int k, int s, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = s; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}
