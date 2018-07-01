package pers.whe.code.leetcode;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Contest91 {

    /*
     * 860. Lemonade Change
     * 这道题说只有面值5，10，20钞票，每个人只能买1个橘子，
     * 一个橘子5元，买橘子的开始没有钱，给我们买橘子的人拥有的钱，
     * 看是否可以找给它们。
     * 1 记录每个面值的个数，
     * 2 我们尽量找大面值， 这样后来才能找小面值
     * */
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                arr[0]++;
            } else if (bill == 10) {
                if (arr[0] <= 0) {
                    return false;
                }
                arr[0]--;
                arr[1]++;
            } else {
                if (arr[1] > 0 && arr[0] > 0) {
                    arr[1]--;
                    arr[0]--;
                    arr[2]++;
                } else if (arr[0] >= 3) {
                    arr[0] -= 3;
                    arr[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /*
     * 863. All Nodes Distance K in Binary Tree
     * 这道题让我们找距离一个节点为k的所有节点
     * 1 先找到所有节点的父节点，这样就可以遍历一个节点高层的节点
     * 2 用dfs 找距离target节点为k的所有点
     * */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, TreeNode> pars = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, null, pars);
        dfs2(target, K, null, pars, res);
        return res;
    }

    private void dfs2(TreeNode root, int k, TreeNode pre, Map<Integer, TreeNode> pars, List<Integer> res) {
        if (root == null) return;
        if (k == 0) {
            res.add(root.val);
            return;
        }
        if (k > 0) {
            if (root.left != pre) dfs2(root.left, k - 1, root, pars, res);
            if (root.right != pre) dfs2(root.right, k - 1, root, pars, res);
            if (pars.get(root.val) != pre) dfs2(pars.get(root.val), k - 1, root, pars, res);
        }
    }

    private void dfs(TreeNode root, TreeNode pre, Map<Integer, TreeNode> pars) {
        if (root == null) return;
        pars.put(root.val, pre);
        dfs(root.left, root, pars);
        dfs(root.right, root, pars);
    }

    /*
     * 861. Score After Flipping Matrix
     * 这道题给我们一个矩阵，矩阵节点为1或0，让我们反转矩阵的行或列，
     * 让得到的行的加最大，
     * 1 行反转，让第一个为1，
     * 2 列反转，让列0最多
     * */
    public int matrixScore(int[][] a) {
        int m = a.length, n = a[0].length;
        for (int i = 0; i < m; i++) {
            if (a[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    a[i][j] ^= 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = 0; j < m; j++) {
                if (a[j][i] == 1) {
                    ones++;
                }
            }
            res = res * 2 + Math.max(ones, m - ones);
        }
        return res;
    }

    /*
     * 862. Shortest Subarray with Sum at Least K
     * 这道题让我们找一个数组的连续子序列，和最小为k，求序列的最小长度。
     * 我们用对列记录升序的值，为什么要记录升序的索引，如过降序的话，和值为负，
     * 在来讨论为什么要加入当前索引，再来看一下当sum[i] <= sum[deque.getLast()】
     * 为什么要pop出去，B[i] - B[d[0]] 可以得到更小的len，更大的sum
     * */
    public int shortestSubarray(int[] a, int k) {
        int n = a.length, res = n + 1;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = a[i] + sum[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (deque.size() > 0 && k <= sum[i] - sum[deque.getFirst()])
                res = Math.min(res, i - deque.pollFirst());
            while (deque.size() > 0 && sum[i] <= sum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}
