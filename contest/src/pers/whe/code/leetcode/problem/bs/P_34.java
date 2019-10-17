package pers.whe.code.leetcode.problem.bs;

public class P_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int l = 0, r = nums.length - 1;
        if (l > r) return res;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] != target) return res;
        res[0] = l;
        r = nums.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l + 1;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        res[1] = l;
        return res;
    }
 }
