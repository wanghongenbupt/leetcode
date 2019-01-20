package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.Arrays;

public class Contest120 {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, res = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                dec = 1;
                inc = 1;
            }
            res = Math.max(res, Math.max(inc, dec));
        }
        return res;
    }


    /*
     * 正， 子给  负 子需要
     * */
    //int res = 0;
    public int distributeCoins(TreeNode root) {
        dsp(root);
        return res;
    }

    private int dsp(TreeNode root) {
        if (root == null) return 0;
        int left = dsp(root.left);
        int right = dsp(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

    int res = 0, empty = 1, sx, sy, ex, ey;

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return;
        if (x == ex && y == ey && empty == 0) res++;
        empty--;
        grid[x][y] = -2;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        empty++;
        grid[x][y] = 0;
    }
}



































