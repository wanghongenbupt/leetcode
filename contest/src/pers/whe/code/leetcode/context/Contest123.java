package pers.whe.code.leetcode.context;

import pers.whe.code.model.Union;

import java.util.*;

public class Contest123 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        new Contest123().addToArrayForm(new int[]{2,1,5}, 806);
    }

    public boolean equationsPossible(String[] equations) {
        Union union = new Union(26);
        for (String str: equations) {
            if (str.charAt(1) == '=') {
                union.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str: equations) {
            if (str.charAt(1) == '!') {
                if (union.equiv(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            res++;
        }
        return res + X - Y;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);
    }

    private int mostK(int[] a, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0, c = 0; j < a.length; j++) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);
            while (map.size() > k) {
                map.put(a[i], map.get(a[i]) - 1);
                if (map.get(a[i]) == 0) {
                    map.remove(a[i]);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}






























