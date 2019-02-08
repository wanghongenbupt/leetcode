package pers.whe.code.leetcode.problem.dp;

public class P_213 {

    /*
    * 213. House Robber II
    * https://mp.csdn.net/mdeditor/86774287#
     * */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }

    private int dp(int[] nums, int l, int r) {
        int[] values = new int[2];
        values[l % 2] = nums[l];
        values[(l + 1) % 2] = Math.max(nums[l], nums[l + 1]);
        for (l += 2; l <= r; l++) {
            values[l % 2] = Math.max(values[(l - 1) % 2], values[(l - 2)%2] + nums[l]);
        }
        return values[r % 2];
    }
}
