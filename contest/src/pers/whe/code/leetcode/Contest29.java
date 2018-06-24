package pers.whe.code.leetcode;

import pers.whe.code.model.TreeNode;

public class Contest29 {


    /*
     * 563. Binary Tree Tilt
     * 这道题属于树，关于树的问题大多递归问题比较好解决。
     * 递归的含义是此子树全部元素的和。
     * 我们取左子树和，右子树和，把差的绝对值加入结果
     * */
    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}