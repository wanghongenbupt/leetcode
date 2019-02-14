package pers.whe.code.leetcode.problem.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_327 {
    /*
    * 327. Count of Range Sum
    * lower <= a <= upper
    * lower <= sum - n <= upper
     * */
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Long> map = new TreeMap<>();
        map.put(0l, 1l);
        long count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            long to = sum - lower;
            long from = sum - upper;
            Map<Long, Long> sub = map.subMap(from, true, to, true);
            for(Long value : sub.values()){
                count+=value;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1l);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return (int)count;
    }
}
