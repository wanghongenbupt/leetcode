package pers.whe.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Context102 {

    /*
    * 905. Sort Array By Parity
    * */
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[j++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                res[j++] = A[i];
            }
        }
        return res;
    }

    /*
    * 904. Fruit Into Baskets
    * */
    public int totalFruit(int[] tree) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < tree.length;) {
            while (i < tree.length && (map.size() < 2 || map.containsKey(tree[i]))) {
                if (map.containsKey(tree[i])) {
                    map.put(tree[i], map.get(tree[i]) + 1);
                } else {
                    map.put(tree[i], 1);
                }
                max = Math.max(max, i - j + 1);
                i++;
            }
            if (map.get(tree[j]) == 1) map.remove(tree[j]);
            else map.put(tree[j], map.get(tree[j]) - 1);
            j++;
        }
        return max;
    }


}
