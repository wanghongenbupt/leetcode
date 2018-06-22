package pers.whe.leetcode;

import pers.whe.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

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


}
