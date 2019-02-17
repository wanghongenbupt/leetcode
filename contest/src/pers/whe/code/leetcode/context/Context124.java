package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Context124 {

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] a = new int[]{1, 2};
        dfs(root, x, y, a, 0);
        return a[0] == a[1];
    }

    private void dfs(TreeNode root, int x, int y, int[] a, int lev) {
        if (root == null) return;
        if (root.val == x) a[0] = lev;
        if (root.val == y) a[1] = lev;
        dfs(root.left, x, y, a, lev + 1);
        dfs(root.right, x, y, a, lev + 1);
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y || root.right.val == x && root.left.val == y) {
                a[0] = 1;
                a[1] = 2;
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (count == 0) return 0;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};
        int leve = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
                    q.offer(new int[]{nx, ny});
                    grid[nx][ny] = 2;
                    count--;
                }
            }
            leve++;
        }
        return count == 0 ? leve : -1;
    }

    int res = 0;
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Set<Integer>> cand = new HashMap<>();

    public int numSquarefulPerms(int[] A) {
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        for (int i : count.keySet()) {
            cand.putIfAbsent(i, new HashSet<>());
            for (int j : count.keySet()) {
                double sq = Math.sqrt(i + j);
                if (sq - Math.floor(sq) == 0) {
                    cand.putIfAbsent(i, new HashSet<>());
                    cand.get(i).add(j);
                }
            }
        }
        for (int c : count.keySet()) {
            dfs(c, A.length - 1);
        }
        return res;
    }

    private void dfs(int x, int left) {
        if (left == 0) {
            res++;
            return;
        }
        count.put(x, count.get(x) - 1);
        for (int y : cand.get(x)) {
            if (count.get(y) > 0) {
                dfs(y, left - 1);
            }
        }
        count.put(x, count.get(x) + 1);
    }

    public static void main(String[] args) {
        new Context124().numSquarefulPerms(new int[]{65, 44, 5, 11});
    }
}
