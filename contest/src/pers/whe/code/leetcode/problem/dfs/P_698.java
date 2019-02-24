package pers.whe.code.leetcode.problem.dfs;

import java.util.Arrays;

public class P_698 {

    /*
     * 698. Partition to K Equal Sum Subsets
     * 暴力求解
     * */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0 || k > nums.length) return false;
        sum /= k;
        Arrays.sort(nums);
        return dfs(nums, new int[k], nums.length - 1, sum);
    }

    private boolean dfs(int[] nums, int[] p, int i, int target) {
        if (i == -1) {
            for (int j : p) if (j != target) return false;
            return true;
        }
        for (int k = 0; k < p.length; k++) {
            if (p[k] + nums[i] <= target) {
                p[k] += nums[i];
                if (dfs(nums, p, i - 1, target)) return true;
                p[k] -= nums[i];
            }
        }
        return false;
    }
}