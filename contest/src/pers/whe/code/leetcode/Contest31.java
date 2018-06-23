package pers.whe.code.leetcode;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Contest31 {

    /*
     * 575. Distribute Candies
     * 这道题是一个模拟题，要把数组分成个数相等的两个，
     * 求数组中元素个数最多有多少不同。大概分两种情况
     * 1 如果不同元素个数足够多，则最多的不同是数组个数的一半
     * 2 如果不同元素个数不多， 则就是不同元素的个数
     * */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int n : candies) {
            set.add(n);
        }
        if (set.size() >= candies.length / 2) {
            return candies.length / 2;
        }
        return set.size();
    }


    /*
     *572. Subtree of Another Tree
     * dfs, 主要明白递归函数的含义
     * */
//  t 是否是s的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val == t.val && dfs(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //  以s为根节点的树，是否有以t为根结点为根的树的相同节点
    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    /*
     * 576. Out of Boundary Paths
     * 这道题是让找从一个矩阵的一点开始，每次可以上下左右，最多能走N步，
     * 问有多少条路可以走出去，可以用dfs,在用map记录当前状态，
     * 递归的定义是：在 i , j 点，最多能走N步，有多少条路。
     * 1 如果当前在外面，返回1
     * 2 如果N = 0。但是还在里面，无路可走，反回0
     * 3 如果到到达过当前状态，直接返回，
     * 4 遍历每个方向
     * */
    public int findPaths(int m, int n, int N, int i, int j) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(m, n, N, i, j, map);
    }

    private int dfs(int m, int n, int N, int i, int j, Map<String, Integer> map) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) return 0;
        String str = Arrays.toString(new int[]{i, j, N});
        if (map.containsKey(str)) return map.get(str);
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int res = 0;
        for (int k = 0; k < dx.length; k++) {
            res = (res + dfs(m, n, N - 1, i + dx[k], j + dy[k], map)) % 1000000007;
        }
        map.put(str, res);
        return res;
    }


}
