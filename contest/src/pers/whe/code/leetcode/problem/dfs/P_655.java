package pers.whe.code.leetcode.problem.dfs;

import pers.whe.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int deepth = deep(root);
        int l = 0, r = (1 << deepth) - 2;
        for (int i = 0; i < deepth; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < r + 1; j++) {
                res.get(i).add("");
            }
        }
        dfs(root, 0, l, r, res);
        return res;
    }

    private void dfs(TreeNode root, int i, int l, int r, List<List<String>> res) {
        if (root == null) return;
        int mid = (l + r) / 2;
        res.get(i).set(mid, root.val + "");
        dfs(root.left, i + 1, l, mid - 1, res);
        dfs(root.right, i + 1, mid + 1, r, res);
    }

    private int deep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }
}
