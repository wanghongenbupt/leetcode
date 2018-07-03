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
}
