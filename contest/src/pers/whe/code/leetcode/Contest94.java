package pers.whe.code.leetcode;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Contest94 {

    /*
    * 872. Leaf-Similar Trees
    * 这道题让我们求两棵树的叶子节点是否完全相似。
    * 1 用dfs求树的叶子节点
    * 2 比较叶子节点
    * */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> l) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            l.add(root.val);
            return;
        }
        dfs(root.left, l);
        dfs(root.right, l);
    }

    /*
    * 874. Walking Robot Simulation
    * 这道题让我们求机器离原点最大的距离。
    * 1 用机器描述数组所走的方向。
    * 2 遍历每个指令，执行命令
    * */
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "" + o[1]);
        }
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, d = 0;
        int res = 0;
        for (int i : commands) {
            if (i == -1) {
                d = (d + 1) % 4;
            } else if (i == -2) {
                d = (d + 3) % 4;
            } else {
                int xd = dx[d];
                int yd = dy[d];
                for (int j = 1; j <= i; j++) {
                    int nx = x + xd;
                    int ny = y + yd;
                    String test = nx + "" + ny;
                    if (!set.contains(test)) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }

    /*
    *875. Koko Eating Bananas
    * 这道题让我们求每小时最少吃多少香蕉，最大值为数组最大值，最小值为1，就是求满足
    * 一定条件的最小值。用二分发来做，如果用的时间大于H，说明吃的太少，加大，
    * */
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = -1;
        for (int i : piles) {
            r = Math.max(r, i);
        }
        while (l < r) {
            int m = (l + r) / 2;
            int time = eat(piles, m);
            if (time > H) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int eat(int[] piles, int m) {
        int res = 0;
        for (int i : piles) {
            res += (int)Math.ceil((double) i / m);
        }
        return res;
    }

    /*
    * 873. Length of Longest Fibonacci Subsequence
    * 让我们求一个数组中斐波那契序列的最长值，可用暴力解法
    * */
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int res = 2;
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i], b = arr[j], len = 2;
                while (set.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    len++;
                }
                res = Math.max(res, len);
            }
        }
        return res > 2 ? res : 0;
    }

}
