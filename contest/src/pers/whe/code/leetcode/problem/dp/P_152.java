package pers.whe.code.leetcode.problem.dp;

public class P_152 {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            int curMax = Math.max(num, Math.max(num * max, num * min));
            int curMin = Math.min(num, Math.min(num * max, num * min));
            res = Math.max(curMax, res);
            max = curMax; min = curMin;
        }
        return res;
    }
}
