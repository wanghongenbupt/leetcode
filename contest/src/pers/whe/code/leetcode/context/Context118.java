package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Context118 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }


    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int x, i;
        for (x = A.length; x > 0; x--) {
            for (i = 0; A[i] != x; i++) ;
            reverse(A, 0, i);
            res.add(i + 1);
            reverse(A, 0, x - 1);
            res.add(x);
        }
        return res;
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    int[] voyage;
    int[] a = new int[1];
    List<Integer> res = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (dfs(root)) {
            return res;
        }
        res.clear();
        res.add(-1);
        return res;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        if (root.val != voyage[a[0]]) return false;
        a[0]++;
        if (root.left != null && root.left.val == voyage[a[0]]) {
            return dfs(root.left) && dfs(root.right);
        } else if (root.left == null) {
            return dfs(root.right);
        }
        res.add(root.val);
        swap(root);
        return dfs(root.left) && dfs(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public boolean isRationalEqual(String S, String T) {
        Fraction f1 = convert(S);
        Fraction f2 = convert(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    private Fraction convert(String s) {
        int stat = 0;
        Fraction res = new Fraction(0, 1);
        int decimal_size = 0;
        for (String part : s.split("[.()]")) {
            stat++;
            if (part.isEmpty()) continue;
            long x = Long.valueOf(part);
            int sz = part.length();
            if (stat == 1) {
                res.add(new Fraction(x, 1));
            } else if (stat == 2) {
                res.add(new Fraction(x, (long) Math.pow(10, sz)));
                decimal_size = sz;
            } else {
                long denom = (long) Math.pow(10, decimal_size);
                denom *= (long) Math.pow(10, sz) - 1;
                res.add(new Fraction(x, denom));
            }
        }
        return res;
    }


}

class Fraction {
    long n, d;

    public Fraction(long n, long d) {
        long g = gcd(n, d);
        this.n = n / g;
        this.d = d / g;
    }

    public void add(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = Fraction.gcd(numerator, denominator);
        this.n = numerator / g;
        this.d = denominator / g;
    }

    static long gcd(long x, long y) {
        return x != 0 ? gcd(y % x, x) : y;
    }
}
