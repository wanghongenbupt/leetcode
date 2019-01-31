package pers.whe.code.leetcode.problem.hash;

import java.util.TreeMap;

public class P_715 {
}

/*
 * 715. Range Module
 * 找范围内的每个区间，如果start <= right
 * 说明区间可能在范围内，如果 end >= left  说明区间就在范围内
 *
 * */
class RangeModule {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        if (left >= right) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start <= right) {
            Integer end = map.get(start);
            if (end >= left) {
                map.remove(start);
                if (start < left) left = start;
                if (end > right) right = end;
            }
            start = map.ceilingKey(end);
        }
        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if (left >= right) return;
        Integer start = map.floorKey(left);
        if (start == null) start = map.ceilingKey(left);
        while (start != null && start <= right) {
            Integer end = map.get(start);
            if (end >= left) {
                map.remove(start);
                if (start < left) map.put(start, left);
                if (end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}
