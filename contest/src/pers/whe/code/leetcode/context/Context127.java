package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.Arrays;

public class Context127 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int res = 0, i = 0;
        while (i < A.length && K > 0) {
            if (A[i] >= 0) break;
            res += Math.abs(A[i]);
            A[i] = -A[i];
            i++;
            K--;
        }
        if (K % 2 == 0) {
            while (i < A.length) {
                res += A[i];
            }
            return res;
        } else {
            int sum = Arrays.stream(A).sum();
            sum -= 2 * Arrays.stream(A).min().getAsInt();
            return sum;
        }
    }

    public int minDominoRotations(int[] A, int[] B) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int cc = 0, aa = 0, bb = 0, kk = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == i || B[j] == i) cc++;
                if (A[j] == i) aa++;
                if (B[j] == i) bb++;
                if (A[j] == i && B[j] == i) kk++;
            }
            if (cc != A.length) continue;
            int tt = Math.min(A.length - aa, A.length - bb);
            res = Math.min(res, tt);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        new Context127().largestSumAfterKNegations(new int[]{4,2,3}, 1);
     //   System.out.println(new Context127().clumsy(10));
    }

    public int clumsy(int N) {
        if (N == 3) return  6;
        if (N == 2) return 2;
        if (N == 1) return  1;
        int res = 0;
        res += help(N);
        N-=4;
        res += (N + 1);
        while (N >= 4) {
            res -= help(N);
            N-=4;
            res += (N + 1);
        }
        if (N == 3) return res - 6;
        if (N == 2) return res - 2;
        if (N == 1) return res - 1;
        return res;
    }

    private int help(int n) {
        int temp = n * (n - 1) / (n - 2);
        return temp;
    }
    int in = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        TreeNode node = new TreeNode(preorder[in++]);
        if (l == r) return node;
        int k = l;
        for (; k <= r; k++) {
            if (preorder[k] > node.val) break;
        }
        node.left = dfs(preorder, in, k - 1);
        node.right = dfs(preorder, k, r);
        return node;
    }
}
