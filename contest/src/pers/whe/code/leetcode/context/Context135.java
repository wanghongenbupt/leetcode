package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

public class Context135 {
    public boolean isBoomerang(int[][] points) {
        if (points[0][0] == points[1][0] && points[0][1] == points[1][1] ||
            points[0][0] == points[2][0] && points[0][1] == points[2][1] ||
            points[2][0] == points[1][0] && points[2][1] == points[1][1] ) {
            return false;
        }
        double p0 = points[0][0] - points[1][0] == 0 ? Double.MAX_VALUE : ((double) (points[0][1] - points[1][1]) / (points[0][0] - points[1][0]));
        double p1 = points[0][0] - points[2][0] == 0 ? Double.MAX_VALUE : ((double) (points[0][1] - points[2][1]) / (points[0][0] - points[2][0]));
        if (p0 == p1) return false;
        return true;
    }

    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        root.val = root.val + val;
        val = root.val;
        dfs(root.left);
    }

    public int minScoreTriangulation(int[] a) {
        int[][] dp = new int[a.length][a.length];
        return dfs1(a, dp, 0, a.length - 1);
    }

    private int dfs1(int[] a, int[][] dp, int i, int j) {
        if (j < i + 2) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs1(a, dp, i, k) + dfs1(a, dp, k, j) + a[i] * a[j] * a[k]);
        }
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        int res = new Context135().minScoreTriangulation(new int[]{1,3,1,4,1,5});
        System.out.println();
    }
}
