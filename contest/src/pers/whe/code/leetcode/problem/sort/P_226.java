package pers.whe.code.leetcode.problem.sort;

import java.util.TreeSet;

public class P_226 {

    /*
    * 220. Contains Duplicate III
    * 当遍历到nums[i]的时候，用set保存最近的k个数据（i - k, i - 1），如果这k个数据中
    * 有与nums[i]相差最大为t的返回true。
    * */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            Long l = set.ceiling(n - t);
            Long  r = set.floor(n + t);
            if (l != null && l <= n || r != null && r >= n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                long m = nums[i - k];
                set.remove(m);
            }
        }
        return false;
    }
}
