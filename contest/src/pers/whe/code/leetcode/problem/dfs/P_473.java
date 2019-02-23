package pers.whe.code.leetcode.problem.dfs;

import java.util.Arrays;

public class P_473 {
    /*
     * 473. Matchsticks to Square
     * */
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) return false;
        return dfs(nums, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] nums, int[] arr, int i, int target) {
        if (i == nums.length) {
            if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == target) {
                return true;
            } else {
                return false;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (arr[j] + nums[i] > target) continue;
            arr[j] += nums[i];
            if (dfs(nums, arr, i + 1, target)) return true; // 只要有一个正确答案就行
            arr[j] -= nums[i];
        }
        return false;
    }
}