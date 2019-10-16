package pers.whe.code.leetcode.problem.bs;

public class P_81 {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (l > r) return false;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] == target) return true;
            if (nums[l] < nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else if (nums[l] > nums[m]) {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                l++;
            }
        }
        return nums[l] == target;
    }

}
