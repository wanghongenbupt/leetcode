package pers.whe.code.leetcode.context;

import java.util.*;

public class Contest158 {

    /*
    * 1221. Split a String in Balanced Strings
    Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

返回可以通过分割得到的平衡字符串的最大数量。
    * */

    public int balancedStringSplit(String s) {
        int res = 0, c = 0;
        if (s.charAt(0) == 'L') {
            c++;
        } else {
            c--;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                c++;
            } else {
                c--;
            }
            if (c == 0) res++;
        }
        return res;
    }

    /*
    * 1222. Queens That Can Attack the King
    On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。

「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。

「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。

请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
    * */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dx = {0, 0, -1, 1, 1, -1, -1, 1}, dy = {1, -1, 0, 0, 1, -1, 1, -1};
        Set<Integer> set = new HashSet<>();
        int m = 8, n = 8;
        for (int[] cur : queens) {
            set.add(cur[0] * 100 + cur[1]);
        }
        for (int i = 0; i < dx.length; i++) {
            int m1 = king[0], n1 = king[1];
            while (m1 >= 0 && n1 >= 0 && m1 < m && n1 < n) {
                if (set.contains(m1 * 100 + n1)) {
                    res.add(Arrays.asList(m1, n1));
                    break;
                }
                m1 += dx[i];
                n1 += dy[i];
            }
        }
        return res;
    }
   /*
   * 1224. Maximum Equal Frequency
   Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.

If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。

不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。

现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。

假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
    * */
    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[6][16];
        long res = 0, mod = (long)1e9 + 7;
        for (int i = 0; i < 6; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            long[][] ndp = new long[6][16];
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= 15; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (j == l) {
                            if (k + 1 <= rollMax[l]) {
                                ndp[j][k + 1] += dp[j][k];
                                ndp[j][k + 1] %= mod;
                            }
                        } else {
                            ndp[l][1] += dp[j][k];
                            ndp[l][1] %= mod;
                        }
                    }
                }
            }
            dp = ndp;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 16; j++) {
                res += dp[i][j];
                res %= mod;
            }
        }
        return (int)res;
    }

    /*
    * 1224. Maximum Equal Frequency
    Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.
    If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
给出一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：

从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
    * */
    public int maxEqualFreq(int[] A) {
        int[] count = new int[100001], freq = new int[100001];
        int max = 0, a = 0, res = 0;
        for (int i = 1; i <= A.length; i++) {
            a = A[i - 1];
            freq[count[a]]--;
            count[a]++;
            freq[count[a]]++;
            max = Math.max(count[a], max);
            if (max == 1 || max * freq[max] == (i - 1) || (freq[max - 1] * (max - 1) + max) == i) {
                res = i;
            }
        }
        return res;
    }

}
