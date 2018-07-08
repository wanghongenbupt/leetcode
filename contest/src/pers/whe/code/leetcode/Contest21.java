package pers.whe.code.leetcode;

import pers.whe.code.model.TreeNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Contest21 {

    /*
     * 530. Minimum Absolute Difference in BST
     * 这道题让我们中序遍历一个二叉排序树，让我们找两个相邻
     * 节点中差最小的数值，
     * 1 记录前一个节点
     * 2 中序遍历每个节点
     * */
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }

    /*
     * 523. Continuous Subarray Sum
     * 让我们找一个数组中，连续数组和能整除k的看是否有这样连续数组。
     * 我们用sum数组记录数组和，
     * */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                int cur = sum[j] - sum[i];
                if (cur == 0 && k == 0 && j - i > 1) {
                    return true;
                }
                if (k != 0 && cur % k == 0 && j - i > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * 524. Longest Word in Dictionary through Deleting
     * 这道题找一个字符串中去掉一些字符和另一个字典相匹配，
     * 1 排序字典，长度，字母顺序排序
     * 2 根据题目意思找匹配字符串
     * */
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        char[] arr = s.toCharArray();
        for (String str : d) {
            if (canForm(arr, str.toCharArray())) {
                return str;
            }
        }
        return "";
    }

    private boolean canForm(char[] s, char[] w) {
        int i = 0, j = 0;
        while (i < s.length && j < w.length) {
            if (s[i] == w[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == w.length;
    }

    /*
     * 529. Minesweeper
     * 这道题目要去去找状态的转换
     * 1 如果是M,直接返回
     * 2 如果是E，周围没有M，bfs遍历四周
     * 3 如果是E,周围有M，计数，赋值返回
     * */
    public char[][] updateBoard(char[][] board, int[] click) {
        char c = board[click[0]][click[1]];
        if (c == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs1(board, click[0], click[1]);
        return board;
    }

    private void dfs1(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') {
            return;
        }
        int mine = 0;
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') {
                    mine++;
                }
            }
        }
        if (mine > 0) {
            board[i][j] = (char) ('0' + mine);
            return;
        }
        board[i][j] = 'B';
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++) {
                if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') {
                    dfs1(board, r, c);
                }
            }
        }
    }
}