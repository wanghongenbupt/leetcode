package pers.whe.code.leetcode.problem.math;

import java.util.Arrays;

public class P_927 {

    /*
    * 927. Three Equal Parts
     * */
    public int[] threeEqualParts(int[] A) {
        // 计算1的数量
        int count = Arrays.stream(A).sum();
        if (count == 0) return new int[]{0, A.length - 1};
        if (count % 3 != 0) return new int[]{-1, -1};
        // 计算每个part1的数量
        count /= 3;
        int i = 0;
        // 找初始1
        for (i = 0; i < A.length; i++) {
            if (A[i] == 1) break;
        }
        int start = i, count1 = 0;
        i = 0;
        // 找第 count + 1 个1
        for (count1 = 0, i = 0; i < A.length; i++) {
            if (A[i] == 1) count1++;
            if (count1 == count + 1) break;
        }
        int mid = i;
        //找第 2 * count + 1 个1
        for (count1 = 0, i = 0; i < A.length; i++) {
            if (A[i] == 1) count1++;
            if (count1 == 2 * count + 1) break;
        }
        int end = i;
        // 匹配
        while (end < A.length && A[start] == A[mid] && A[mid] == A[end]) {
            start++;mid++;end++;
        }
        if (end == A.length) return new int[]{start - 1, mid};
        return new int[]{-1, -1};
    }
}
