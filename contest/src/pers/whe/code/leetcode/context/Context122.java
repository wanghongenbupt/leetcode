package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Context122 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int oh = Arrays.stream(A).filter(i -> i % 2 == 0).sum();
        for (int j = 0; j < queries.length; j++) {
            int[] q = queries[j];
            int i = q[0], n = q[1];
            if (A[i] % 2 == 0) {
                oh -= A[i];
            }
            A[i] += n;
            if (A[i] % 2 == 0) {
                oh += A[i];
            }
            res[j] = oh;
        }
        return res;
    }

    public static void main(String[] args) {

    }

    String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        if (root == null) return;
        s = (char)('a' + root.val) + s;
        if (root.left == null && root.right == null) {
           if (s.compareTo(res) < 0) {
               res = s;
           }
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }


    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        Interval[] res = new Interval[A.length + B.length];
        int p = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int l = Math.max(A[i].start, B[j].start);
                int r = Math.min(A[i].end, B[j].end);
                if (l <= r) {
                    res[p++] = new Interval(l, r);
                }
            }
        }
        return Arrays.copyOf(res, p);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int cur: map.keySet()) {
            List<Integer> next = new ArrayList<>();
            for (List<Integer> n : map.get(cur).values()) {
                List<Integer> s = n;
                Collections.sort(s);
                next.addAll(s);
            }
            res.add(next);
        }
        return res;
    }

    private void dfs(TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, TreeNode root, int xl, int yl) {
        if (root == null) return;
        if (!map.containsKey(xl)) {
            map.put(xl, new TreeMap<>(Collections.reverseOrder()));
        }
        if (!map.get(xl).containsKey(yl)) {
            map.get(xl).put(yl, new ArrayList<>());
        }
        map.get(xl).get(yl).add(root.val);
        dfs(map, root.left, xl-1,yl-1);
        dfs(map, root.right,  xl + 1, yl + 1);
    }

}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}