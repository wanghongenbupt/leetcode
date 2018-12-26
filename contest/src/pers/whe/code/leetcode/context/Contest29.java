package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /*
     *561. Array Partition I
     * an < bn
     * sm = a1 + b1 + a2 + b2 + ....
     * di = bi - ai;
     * dm = b1 - a1 + b2 - a2 + ....
     * am = (a1 + b1 - (b1 - a1)) = (sm - dm) / 2;
     * to get largest am , make dm small;
     *
     * time o(nlog(n)),  space o(1)
     * */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /*
     * 564. Find the Closest Palindrome
     * 这里总共有5个候选者， 如 12345
     * 有 12321， 12221， 12421， 9999， 100001，
     * 如 123456  有候选者
     *    123321， 124421， 122221， 99999， 1000000
     *    比较他们和原数差的绝对值
     * */
    public String nearestPalindromic(String n) {
        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long left = Long.valueOf(n.substring(0, i + 1));
        List<Long> list = new ArrayList<>();
        list.add(getPalindrome(left, len % 2 == 0));
        list.add(getPalindrome(left + 1, len % 2 == 0));
        list.add(getPalindrome(left - 1, len % 2 == 0));
        list.add((long) Math.pow(10, len) + 1);
        list.add((long) Math.pow(10, len - 1) - 1);
        long diff = Long.MAX_VALUE, res = 0, dl = Long.valueOf(n);
        for (long num : list) {
            if (dl == num) continue;
            if (Math.abs(dl - num) < diff) {
                res = num;
                diff = Math.abs(dl - num);
            } else if (Math.abs(dl - num) == diff) {
                res = Math.min(res, num);
            }
        }
        return String.valueOf(res);
    }

    private long getPalindrome(long l, boolean b) {
        long res = l;
        if (!b) l /= 10;
        while (l > 0) {
            res = res * 10 + l % 10;
            l /= 10;
        }
        return res;
    }
}