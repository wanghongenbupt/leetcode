package pers.whe.code.leetcode.problem.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class P_996 {

    /*
     * 996. Number of Squareful Arrays
     * */
    int count = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        dfs(A, new ArrayList<Integer>(), new boolean[A.length], -1);
        return count;
    }

    private void dfs(int[] a, ArrayList<Integer> temp, boolean[] used, int i) {
        if (temp.size() == a.length) {
            count++;
        } else {
            for (int j = 0; j < a.length; j++) {
                if (used[j] || (j > 0 && a[j] == a[j - 1] && used[j - 1])) continue;
                if (i != -1) {
                    if (!isS(a[j], i)) {
                        continue;
                    }
                }
                used[j] = true;
                temp.add(a[j]);
                dfs(a, temp, used, a[j]);
                temp.remove(temp.size() - 1);
                used[j] = false;
            }
        }
    }

    private boolean isS(int a, int b) {
        double sqr = Math.sqrt(a + b);
        return sqr - Math.floor(sqr) == 0;
    }
}
