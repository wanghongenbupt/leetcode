package pers.whe.code.leetcode.problem.dfs;

public class P_397 {
    /*
    * 397. Integer Replacement
     * */
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        if (n % 2 == 1) {
            return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
        }
        return 1;
    }
}
