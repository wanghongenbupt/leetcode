package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, used, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, boolean[] used, ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            dfs(nums, res, used, temp);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
