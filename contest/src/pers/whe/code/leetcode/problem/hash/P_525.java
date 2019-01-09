package pers.whe.code.leetcode.problem.hash;

import java.util.HashMap;
import java.util.Map;

public class P_525 {

    /*
     * 525. Contiguous Array
     * 把0变为-1，
     * 记录前缀和，例如数组  1，-1， 1， 1；
     *           前缀合为0，1， 0， 1， 2，
     * 前缀和相同的内的数有相同个数的-1，1。
     * */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> cur = new HashMap<>();
        int sum = 0;
        cur.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (cur.containsKey(sum)) {
                max = Math.max(max, i - cur.get(sum));
            } else {
                cur.put(sum, i);
            }
        }
        return max;
    }
}
