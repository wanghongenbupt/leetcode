package pers.whe.code.leetcode.problem.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        int[] det = new int[256];
        for (int i = 0; i < n; i++) {
            det[s.charAt(i)]++;
            det[p.charAt(i)]--;
        }
        int sum = 0;
        for (int i = 0; i < 256; i++) sum += Math.abs(det[i]);
        if (sum == 0) res.add(0);
        for (int i = n; i < m; i++) {
            int l = s.charAt(i - n), r = s.charAt(i);
            sum = sum - Math.abs(det[l]) - Math.abs(det[r]);
            det[l]--;
            det[r]++;
            sum = sum + Math.abs(det[l]) + Math.abs(det[r]);
            if (sum == 0) res.add(i - n + 1);
        }
        return res;
    }
}
