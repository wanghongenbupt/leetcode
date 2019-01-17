package pers.whe.code.leetcode.problem.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_826 {

    /*
    * 826. Most Profit Assigning Work
    * 找到每个worker所能做任务的最大值，用map记录任务和最大值
    * 并用max记录困难程度在i前能得到的最大报酬
     * */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> jobs = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            int diff = difficulty[i];
            int max = jobs.get(diff) == null ? 0 : jobs.get(diff);
            jobs.put(diff, Math.max(max, profit[i]));
        }
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        int res = 0;
        int i = 0;
        int max = 0;
        for (int w: worker) {
            for (; i < difficulty.length && difficulty[i] <= w; i++) {
                max = Math.max(max, jobs.get(difficulty[i]));
            }
            res += max;
        }
        return res;
    }
}
