package pers.whe.code.leetcode.problem.dfs;

import pers.whe.code.model.TreeNode;

public class P_897 {

    /*
    * 897. Increasing Order Search Tree
     * */
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        pre = res;
        dfs(root);
        return res.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        root.left = null;
        pre.right = root;
        pre = root;
        dfs(root.right);
    }
}
