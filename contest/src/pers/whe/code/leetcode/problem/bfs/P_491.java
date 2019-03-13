package pers.whe.code.leetcode.problem.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        dfs(res, nums, 0, new ArrayList<Integer>());
        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, int[] nums, int s, ArrayList<Integer> item) {
        if (item.size() >= 2) {
            res.add(new ArrayList<>(item));
        }
        for (int i = s; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (item.size() == 0 || nums[i] >= item.get(item.size() - 1)) {
                item.add(nums[i]);
                dfs(res, nums, i + 1, item);
                item.remove(item.size() - 1);
            }
        }
    }
}
