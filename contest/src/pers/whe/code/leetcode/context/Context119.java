package pers.whe.code.leetcode.context;

import java.util.*;

public class Context119 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Context119().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(count, 0) + 1);
        }
        return res;
    }

    public int oddEvenJumps(int[] A) {
        int n = A.length, res = 1;
        boolean[] heigher = new boolean[n], lower = new boolean[n];
        heigher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Integer hi = map.ceilingKey(A[i]), lo = map.floorKey(A[i]);
            if (hi != null) heigher[i] = lower[map.get(hi)];
            if (lo != null) lower[i] = heigher[map.get(lo)];
            if (heigher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }
}
