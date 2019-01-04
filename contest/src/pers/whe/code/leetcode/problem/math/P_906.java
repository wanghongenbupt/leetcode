package pers.whe.code.leetcode.problem.math;

public class P_906 {

    /*
     * 906. Super Palindromes
     * r < 10e18  k*k'= sprt(r) < 10e9  k < 10e5
     * */
    public int superpalindromesInRange(String L, String R) {
        long a = Long.valueOf(L);
        long b = Long.valueOf(R);
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            for (int j = 0; j <= 1; j++) {
                long plain = getPlain(i, j);
                long superPlain = plain * plain;
                if (superPlain >= a && superPlain <= b && isPlain(superPlain)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPlain(long superPlain) {
        String s = String.valueOf(superPlain);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private long getPlain(int x, int addEnd) {
        long y = x;
        if (addEnd == 0) x /= 10;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
