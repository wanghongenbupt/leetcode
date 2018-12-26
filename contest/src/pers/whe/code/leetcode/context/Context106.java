package pers.whe.code.leetcode.context;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Context106 {

    /*
    * 922. Sort Array By Parity II
    * */
    public int[] sortArrayByParityII(int[] a) {
        List<Integer> o = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        for (int i: a) {
            if (i % 2 == 0) {
                o.add(i);
            } else {
                e.add(i);
            }
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                res[i] = o.get(i / 2);
            } else {
                res[i] = e.get(i / 2);
            }
        }
        return res;
    }

    /*
    * 921. Minimum Add to Make Parentheses Valid
    * */
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left + right;
    }

    /*
    * 923. 3Sum With Multiplicity
    * */
    public int threeSumMulti(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = 0; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (i < j && j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }



}
