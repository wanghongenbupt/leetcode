package pers.whe.code.leetcode.problem.interval;

import java.util.*;

public class P_218 {

    /*
    * 218. The Skyline Problem
    * 对初始值排序
     * */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        for (int[] build : buildings) {
            points.add(new int[]{build[0], build[2]});
            points.add(new int[]{build[1], -build[2]});
        }
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int pre = 0;
        for (int[] point: points) {
            if (point[1] > 0) {
                q.offer(point[1]);
            } else {
                q.remove(-point[1]);
            }
            int cur = q.isEmpty() ? 0 : q.peek();
            if (cur != pre) {
                res.add(new int[]{point[0], cur});
            }
            pre = cur;
        }
        return res;
    }
}
