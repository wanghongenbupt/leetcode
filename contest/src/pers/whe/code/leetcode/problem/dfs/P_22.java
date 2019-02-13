package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.List;

public class P_22 {

    /*
    * 22. Generate Parentheses
    * 根据定义，)不能大于 (个数
    * */
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

    private void dfs(String s, int l, int r, int n) {
        if (l == n && r == n) res.add(s);
        if (l > n || r > n) return;
        if (l > r) dfs(s + ")", l, r + 1, n);
        dfs(s + "(", l + 1, r, n);
    }
}
