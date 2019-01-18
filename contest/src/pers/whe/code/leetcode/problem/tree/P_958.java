package pers.whe.code.leetcode.problem.tree;

import pers.whe.code.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P_958 {

    /*
    * 958. Check Completeness of a Binary Tree
    * 我们层序遍历二叉树，当本节点不为空而之前节点为空时就不是
    * 完全二叉树。
     * */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasBlack = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                if (hasBlack) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                hasBlack = true;
            }
        }
        return true;
    }
}
