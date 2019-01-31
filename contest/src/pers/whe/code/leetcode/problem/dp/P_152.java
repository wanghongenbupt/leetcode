package pers.whe.code.leetcode.problem.dp;

public class P_152 {
    /*
    * 152. Maximum Product Subarray
    * 以 i 为结尾的最大，最小
     * */
    public int maxProduct(int[] nums) {
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cmax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int cmin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            res = Math.max(res, cmax);
            max = cmax; min = cmin;
        }
        return max;
    }
}
