package pers.whe.code.util;

import pers.whe.code.model.TreeNode;

public class TreeNodeUtil {

    // 从层序和中序遍历创建二叉树
    private static TreeNode dfs(int[] ceng, int[] in) {
        TreeNode[] size = new TreeNode[ceng.length];
        int m = find(ceng[0], in);
        TreeNode root = new TreeNode(ceng[0]);
        size[m] = root;
        for (int i = 1; i < ceng.length; i++) {
            boolean su = false;
            m = find(ceng[i], in);
            size[m] = new TreeNode(ceng[i]);
            for (int l = m - 1; l >= 0; l--) {
                if (size[l] != null) {
                    if (size[l].right == null) {
                        size[l].right = size[m];
                        su = true;
                    }
                    break;
                }
            }
            if (su) continue;
            for (int r = m + 1; r < ceng.length; r++) {
                if (size[r] != null) {
                    if (size[r].left == null) {
                        size[r].left = size[m];
                    }
                }
                break;
            }
        }
        return root;
    }

    private static int find(int m, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == m) return i;
        }
        return 0;
    }


}
