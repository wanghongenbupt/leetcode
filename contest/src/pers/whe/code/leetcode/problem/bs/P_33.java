package pers.whe.code.leetcode.problem.bs;

public class P_33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (l > r) return -1;
        while (l + 1 < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) return m;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            if (nums[l] < nums[m]) {
                if (nums[l] < target && target < nums[m]) {
                    r = m;
                } else {
                    l = m;
                }
            } else {
                if (nums[m] < target && target < nums[r]) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}
