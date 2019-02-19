package pers.whe.code.leetcode.problem.sort;

import java.util.Arrays;

public class P_493 {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        int res = sort(nums, l, m) + sort(nums, m + 1, r);
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && nums[i] > 2 * nums[j]) {
                j++;
            }
            res += j - m - 1;
        }
        Arrays.sort(nums, l, r + 1);
        return res;
    }
}
