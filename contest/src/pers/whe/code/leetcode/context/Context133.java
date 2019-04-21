package pers.whe.code.leetcode.context;

import java.util.*;

public class Context133 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<int[]>();
        final int r = r0, c = c0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res.add(new int[]{i, j});
            }
        }
        Collections.sort(res, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int c1 = Math.abs(r - o1[0]) + Math.abs(c - o1[1]);
                int c2 = Math.abs(r - o2[0]) + Math.abs(c - o2[1]);
                return c1 - c2;
            }
        });
        return res.toArray(new int[R * C][2]);
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)-> a[0] - a[1] - (b[0] - b[1]));
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length;i++) {
            res += costs[i][1];
        }
        return res;
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        int res = 0;
        for (int i = 0; i + L <= n; i++) {
            int sum = prefix[i + L] - prefix[i];
            for (int j = 0; j + M <= i; j++) {
                res = Math.max(res, prefix[j + M] - prefix[j] + sum);
            }
            for (int j = i + L; j + M <= n; j++) {
                res = Math.max(res, prefix[j + M] - prefix[j] + sum);
            }
        }
        return res;
    }


}

class StreamChecker {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createRoot(words);
    }

    private void createRoot(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for(int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.isWord = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode cur = root;
        for (int i = sb.length() - 1; i >= 0 && cur != null; i--) {
            int index = sb.charAt(i) - 'a';
            cur = cur.next[index];
            if (cur != null && cur.isWord) {
                return true;
            }
        }
        return false;
    }
}
