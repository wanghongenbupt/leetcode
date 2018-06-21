package pers.whe.leetcode;

import java.util.Arrays;

public class Contest32 {

    public static void main(String[] args) {
        new Contest32().findUnsortedSubarray(new int[]{1, 2, 3, 4});
    }

    /*
     * 581. Shortest Unsorted Continuous Subarray
     * 这是一个模拟题，主要找一个数组中没有排序的部分，
     * 可以先对数组排序，然后分别从前往后遍历，找第一个没有排序的数，
     * 然后从后往前遍历，也是找第一个没有排序的数，这两个并且中间的数
     * 就是没有排序的子数组。
     * */
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                l = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != arr[i]) {
                r = i;
                break;
            }
        }
        return l != -1 ? (r - l + 1) : 0;
    }

    /*
     *  583. Delete Operation for Two Strings
     *  这道题用动态规划来做，
     *  1 状态 dp[i][j] word1 第i个字符  word2 第j个字符所对应的最长子序列，
     *  2 转换方程  当 word1 第i个字符 == word2 第j个字符 dp[i][j] = dp[i - 1][j - 1] + 1;
     *             当 word1 第i个字符 != word2 第j个字符 dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
     *  3 初始条件  dp[0 - word1.length()][0] = 0; dp[0][0 - word2.length()] = 0;
     *  4 结果      dp[word1.length()][word2.length()]
     *  这道题要我们求最少删除的字符数，我们求得最大公共子序列之后，
     *  每个字符串减去最大公共子序列就行
     * */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    /*
     * 469. Convex Polygon
     * 这道题让我们判断多边形是不是凸包，有很多多方法，我们用比较简单的一种方法
     * 如点a , b,  c 三个顺时针连续的点，组成2个向量  ab,  bc,
     * 对这个向量叉乘，如果大于0，则夹角为小于180'是凸角，依次计算每个角，都要
     * 是凸角最后才是凸多边形
     * */
    public boolean isConvex(int[][] point) {
        // write your code here
        int n = point.length;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int[] q = point[(i - 1 + n) % n];
            int[] m = point[i];
            int[] h = point[(i + 1) % n];
            int qmx = m[0] - q[0];
            int qmy = m[1] - q[1];
            int mhx = h[0] - m[0];
            int mhy = h[1] - m[1];
            int cur = qmx * mhy - qmy * mhx;
            if (cur != 0) {
                if (cur * pre < 0) return false;
                else pre = cur;
            }
        }
        return true;
    }
}
