package pers.whe.code.leetcode.problem.dfs;

import pers.whe.code.model.TreeNode;

public class P_968 {

    /*
     * 968. Binary Tree Cameras
     * 贪心，让非叶子节点放置相机。
     * 0 如果是叶子节点
     * 1 非叶子节点，并放置相机
     * 2 被记录，可能它的子节点或父节点放了相机。
     * */
    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;   // 跟节点可能没有被
    }

    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
