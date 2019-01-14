package pers.whe.code.leetcode.problem.twopoint;

public class P_209 {

    /*
     * 209. Minimum Size Subarray Sum
     * 双指针
     * */
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum >= s) {
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
