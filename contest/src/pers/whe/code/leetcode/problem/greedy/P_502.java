package pers.whe.code.leetcode.problem.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_502 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Queue<int[]> max = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        Queue<int[]> min = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int i = 0; i < Profits.length; i++) {
            min.offer(new int[]{Profits[i], Capital[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && min.peek()[1] <= W) {
                max.offer(min.poll());
            }
            if (max.isEmpty()) break;
            W += max.poll()[0];
        }
        return W;
    }
}
