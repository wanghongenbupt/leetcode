package pers.whe.code.leetcode.problem.bs;

public class P_154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m;
            } else {
                r--;
            }
        }
        if (nums[l] < nums[r]) return nums[l];
        return nums[r];
    }
}
