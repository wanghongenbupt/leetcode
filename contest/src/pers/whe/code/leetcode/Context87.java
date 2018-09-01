package pers.whe.code.leetcode;

import java.util.*;

public class Context87 {

    /*
    * 844. Backspace String Compare
    * */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (ss.size() > 0) {
                    ss.pop();
                }
            }else {
                ss.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (tt.size() > 0) {
                    tt.pop();
                }
            }  else {
                tt.push(c);
            }
        }
        String strs = "";
        for (char c : ss) {
            strs += c;
        }
        String strt = "";
        for (char c : tt) {
            strt += c;
        }
        if (strs.equals(strt)) {
            return true;
        }
        return false;
    }

    /*
    * 845. Longest Mountain in Array
    * */
    public  int longestMountain(int[] a) {
        if (a.length == 0) return 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        for(int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (left[i] <= 1) continue;
            if (right[i] <= 1) continue;
            max = Math.max(max, left[i] + right[i] - 1);
        }
        return max >= 3 ? max : 0;
    }

    /*
    * 846. Hand of Straights
    * */
    public boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            int c = map.getOrDefault(i, 0) + 1;
            map.put(i, c);
        }
        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int i = 0; i < w; i++) {
                int next = start + i;
                if (!map.containsKey(next)) {
                    return false;
                }
                if (map.get(next) == 1) {
                    map.remove(next);
                } else {
                    map.put(next, map.get(next) - 1);
                }
            }
        }
        return true;
    }

    /*
    * 847. Shortest Path Visiting All Nodes
    * */
    public int shortestPathLength(int[][] graph) {
        return 0;
    }

}
