package pers.whe.code.leetcode.problem.priorityQueue;

import java.util.List;
import java.util.PriorityQueue;

public class P_632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a,b)->a.val - b.val);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> num = nums.get(i);
            pq.add(new Element(num.get(0), 0, i));
            max = Math.max(max, num.get(0));
        }

        int l = -1, r = -1, range = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            Element e = pq.poll();
            if (max - e.val < range) {
                range = max - e.val;
                l = e.val;
                r = max;
            }
            if (e.index + 1 < nums.get(e.row).size()) {
                e.index = e.index + 1;
                e.val = nums.get(e.row).get(e.index);
                pq.add(e);
                if (max < e.val) {
                    max = e.val;
                }
            }
        }
        return new int[]{l, r};
    }
}

class Element {
    int val, index, row;

    public Element(int v, int i, int r) {
        val = v; index = i; row = r;
    }
}