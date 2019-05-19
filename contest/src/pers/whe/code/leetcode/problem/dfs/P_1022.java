package pers.whe.code.leetcode.problem.dfs;

import pers.whe.code.model.TreeNode;

public class P_1022 {

    long res = 0l;
    int mod = (int)1e9 + 7;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0l);
        return (int)res;
    }

    private void dfs(TreeNode root, long cur) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res = (res + cur * 2 + root.val) % mod;
        }
        dfs(root.left, (cur * 2 + root.val) % mod);
        dfs(root.right, (cur * 2 + root.val) % mod);
    }
}
