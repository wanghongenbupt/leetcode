package pers.whe.code.leetcode.problem.bfs;

import java.util.*;

public class P_433 {

    public static void main(String[] args) {
        System.out.println(new P_433().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }

    /*
    * 433. Minimum Genetic Mutation
    * 求最短路径，用BFS
    * */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> see = new HashSet<>();
        see.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.equals(end)) return level;
                for (String next: getNext(set, see, str)) {
                    q.add(next);
                    see.add(next);
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> getNext(Set<String> set, Set<String> see, String str) {
        char[] arr = str.toCharArray();
        List<String> res = new ArrayList<>();
        char[] swap = new char[]{'A', 'C', 'G', 'T'};
        for (int i = 0; i < arr.length; i++) {
            char y = arr[i];
            for (int j = 0; j < swap.length; j++) {
                arr[i] = swap[j];
                String next = new String(arr);
                if (see.contains(next)) continue;
                if (!set.contains(next)) continue;
                res.add(next);
            }
            arr[i] = y;
        }
        return res;
    }

}
