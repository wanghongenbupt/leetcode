package pers.whe.code.leetcode.context;

public class Contest30 {


    /*
     * 566. Reshape the Matrix
     * 这道题主要为了实现Matlab中的reshape函数，
     * 可以遍历原矩阵，并把值付给新矩阵得到
     * */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if (m == 0) return nums;
        int n = nums[0].length;
        if (n == 0) return nums;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return res;
    }

    /*
     * 560. Subarray Sum Equals K
     * 这道题主要求有多少个连续子数组的和等于K,
     * 1 为了快速求出任意中间的连续元素的和，我们求从第0个到给定位置
     * 的数组的和，则可以快速求出 i -- j 的和为 sum[j] - sum[i - 1];
     * 然后遍历数组任意两个位置。
     * */
    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int cur = 0;
                if (j == 0) {
                    cur = nums[i];
                } else {
                    cur = nums[i] - nums[j - 1];
                }
                if (cur == k) {
                    res++;
                }
            }
        }
        return res;
    }

    /*
     * 567. Permutation in String
     * 这道题是找s2中是否包含s1的排列，我们可以遍历s2，只要s2连续字符串中
     * 包含s1的全部内容就行。
     * time O(256 * s2.length) space O(1)
     * */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] tar = new int[256];
        for (char c : s1.toCharArray()) {
            tar[c]++;
        }
        int[] sou = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            sou[s2.charAt(i)]++;
        }
        if (isMatch(tar, sou)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            sou[s2.charAt(i - s1.length())]--;
            sou[s2.charAt(i)]++;
            if (isMatch(tar, sou)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(int[] tar, int[] sou) {
        for (int i = 0; i < tar.length; i++) {
            if (tar[i] != sou[i]) {
                return false;
            }
        }
        return true;
    }
}
