package pers.whe.code.leetcode.problem.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_368 {

    /*
     * 368. Largest Divisible Subset
     *
     * */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] par = new int[n];
        Arrays.sort(nums);
        int max = 0, to = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            par[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        par[i] = j;
                    }
                }
            }
            if (max < count[i]) {
                max = count[i];
                to = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (to != -1) {
            res.add(nums[to]);
            to = par[to];
        }
        return res;
    }
}
