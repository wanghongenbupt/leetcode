package pers.whe.code.leetcode.problem.bs;

public class P_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return bs(nums1, 0, nums2, 0, n / 2 + 1);
        } else {
            return (bs(nums1, 0, nums2, 0, n / 2) + bs(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
        }
    }

    private double bs(int[] a, int i, int[] b, int j, int k) {
        if (i >= a.length) return b[j + k - 1];
        if (j >= b.length) return a[i + k - 1];
        if (k == 0) return Math.min(a[i], b[j]);
        int am = i + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[i + k / 2 - 1];
        int bm = j + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[j + k / 2 - 1];
        if (am < bm) {
            return bs(a, i + k/2, b, j, k - k /2);
        } else {
            return bs(a, i, b, j + k/2, k - k /2);
        }
    }
}
