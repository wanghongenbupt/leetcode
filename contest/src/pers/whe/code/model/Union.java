package pers.whe.code.model;

import java.util.Arrays;

public class Union {
    int[] parent;

    public Union(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int root(int x) {
        return parent[x] < 0 ? x : (parent[x] = root(parent[x]));
    }

    public boolean equiv(int x, int y) {
        return root(x) == root(y);
    }

    public boolean union(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (-parent[x] < -parent[y]) {
                int t = x;
                x = y;
                y = t;
            }
            parent[x] += parent[y];
            parent[y] = x;
        }
        return x == y;
    }

    public int count() {
        int res = 0;
        for (int v : parent) {
            if (v < 0) {
                res++;
            }
        }
        return res;
    }
}
