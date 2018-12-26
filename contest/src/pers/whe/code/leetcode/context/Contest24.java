package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Contest24 {

    /*
     * 543. Diameter of Binary Tree
     * 这道题数据结构是树，一般用分治的思想，就是把问题分为子问题，
     * 最后在合并子问题，递归的定义是以root为根节点的到最下面最大的长度+1，
     * */
    int max = 0;
    /*
     * 538. Convert BST to Greater Tree\
     * 这道题也是一颗二叉树，分治思想，
     * 递归定义是右子树先把任务完成，再把和加到当前节点，完成左侧任务
     * */
    int pre = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public TreeNode convertBST(TreeNode root) {
        dfs2(root);
        return root;
    }

    private void dfs2(TreeNode root) {
        if (root == null) return;
        dfs2(root.right);
        root.val += pre;
        pre = root.val;
        dfs2(root.left);
    }

    /*
     * 542. 01 Matrix
     * 这道题相当于求一些点到一些集合的最小值，相当于盆地蔓延，盆地蔓延
     * 这样的问题用bps来解。
     * */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] <= matrix[cur[0]][cur[1]] + 1) {
                    continue;
                }
                matrix[nx][ny] = matrix[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return matrix;
    }
}
