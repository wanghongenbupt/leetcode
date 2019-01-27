package pers.whe.code.leetcode.problem.tree.segment;

public class P_307 {


}

/*
 * 307. Range Sum Query - Mutable
 * */
class NumArray {

    TreeNode root;

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) {
            TreeNode cur = new TreeNode(l, r);
            cur.sum = nums[l];
            return cur;
        }
        int mid = (l + r) / 2;
        TreeNode cur = new TreeNode(l, r);
        cur.left = build(nums, l, mid);
        cur.right = build(nums, mid + 1, r);
        cur.sum = cur.left.sum + cur.right.sum;
        return cur;
    }

    public void update(int i, int val) {
        update(i, val, root);
    }

    private void update(int i, int val, TreeNode root) {
        if (root.start == root.end && root.start == i) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (i <= mid) {
            update(i, val, root.left);
        } else {
            update(i, val, root.right);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int l, int r) {
        return sumRange(l, r, root);
    }

    private int sumRange(int l, int r, TreeNode root) {
        if (root.start == l && root.end == r) return root.sum;
        int mid = (root.start + root.end) / 2;
        if (r <= mid) {
            return sumRange(l, r, root.left);
        } else if (l > mid) {
            return sumRange(l, r, root.right);
        }
        return sumRange(l, mid, root.left) + sumRange(mid + 1, r, root.right);
    }
}

class TreeNode {
    int start, end, sum;
    TreeNode left, right;

    public TreeNode(int s, int e) {
        start = s;
        end = e;
    }
}