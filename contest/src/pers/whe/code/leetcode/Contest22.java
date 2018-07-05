package pers.whe.code.leetcode;

import java.util.Arrays;

public class Contest22 {

    /*
     * 532. K-diff Pairs in an Array
     * 这道题找数组中相差为k对元素对数，可以用暴力解法，
     * 1 先对数组排序，
     * 2 遍历数组，找后面对，如过相差为k，加入数组中。
     * */
    public int findPairs(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + k == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    /*
     * 514. Freedom Trail
     * 题目让我们转一个圆盘，12点钟对应的字符串连接起来为key，
     * 我们可以用记忆话搜素来做，其中memo[i][j]表示key在第j个字符串，并且12点钟ring
     * 所在第位置为i，
     * */
    public int findRotateSteps(String ring, String key) {
        char[] rarr = ring.toCharArray();
        char[] karr = key.toCharArray();
        return dfs(rarr, karr, 0, 0, new int[rarr.length][karr.length]);
    }

    private int dfs(char[] ring, char[] tar, int tarIndex, int ringIndex, int[][] memo) {
        if (tarIndex == tar.length) {
            return 0;
        }
        if (memo[ringIndex][tarIndex] > 0) {
            return memo[ringIndex][tarIndex];
        }
        int min = Integer.MAX_VALUE;
        char c = tar[tarIndex];
        for (int i = 0; i < ring.length; i++) {
            if (c == ring[i]) {
                int diff = Math.abs(i - ringIndex);
                int distance = 1 + Math.min(diff, ring.length - diff) + dfs(ring, tar, tarIndex + 1, i, memo);
                min = Math.min(min, distance);
            }
        }
        memo[ringIndex][tarIndex] = min;
        return min;
    }
}
