package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Context125 {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) return 1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] t : trust) {
            map.putIfAbsent(t[1], new HashSet<>());
            map.get(t[1]).add(t[0]);
        }
        if (map.isEmpty()) return -1;
        Set<Integer> res = new HashSet<>();
        for (int key : map.keySet()) {
            if (map.get(key).size() == N - 1) res.add(key);
        }
        if (res.size() != 1) return -1;
        int fg = res.iterator().next();
        for (int[] t : trust) {
            if (t[0] == fg) return -1;
        }
        return fg;
    }

    public int numRookCaptures(char[][] board) {
        int r = 0, c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        int res = 0;
        for (int i = r; i >= 0; i--) {
            if (board[i][c] == '.') continue;
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                res++;
                break;
            }
        }
        for (int i = r; i < board.length; i++) {
            if (board[i][c] == '.') continue;
            if (board[i][c] == 'B') break;
            if (board[i][c] == 'p') {
                res++;
                break;
            }
        }
        for (int i = c; i >= 0; i--) {
            if (board[r][i] == '.') continue;
            if (board[r][i] == 'B') break;
            if (board[r][i] == 'p') {
                res++;
                break;
            }
        }
        for (int i = c; i < board[0].length; i++) {
            if (board[r][i] == '.') continue;
            if (board[r][i] == 'B') break;
            if (board[r][i] == 'p') {
                res++;
                break;
            }
        }
        return res;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        if (list.contains(val)) return root;
        list.add(val);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return func(arr, 0, arr.length - 1);
    }

    private void dfs(List<Integer> list, TreeNode root) {
        if (root == null) return;
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    public TreeNode func(int[] nums, int start, int end) {
        int maxindex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxindex])
                maxindex = i;
        }

        TreeNode root = new TreeNode(nums[maxindex]);
        if (maxindex > start)
            root.left = func(nums, start, maxindex - 1);
        if (maxindex < end)
            root.right = func(nums, maxindex + 1, end);


        return root;
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Set<Integer> set = new HashSet<>();
        for (int[] lamp : lamps) {
            set.add(lamp[0] * N + lamp[1]);
        }
        int[] dx = new int[]{0, -1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = new int[]{0, 0, 0, -1, 1, 1, -1, 1, -1};
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<Integer> cur = new HashSet<>(set);
            int[] q = queries[i];
            for (int lamp : set) {
                int x = lamp / N, y = lamp % N;
                if (q[0] == x || q[1] == y || q[0] - x == q[1] - y || q[0] - x == y - q[1]) {
                    res[i] = 1;
                }
                for (int k = 0; k < dx.length; k++) {
                    int nx = q[0] + dx[k];
                    int ny = q[1] + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        set.remove(nx * N + ny);
                    }
                }
                set = cur;
            }
        }
        return res;
    }
}
