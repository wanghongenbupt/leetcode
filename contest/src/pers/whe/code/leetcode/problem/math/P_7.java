package pers.whe.code.leetcode.problem.math;

public class P_7 {

    /*
    * 7. Reverse Integer
    *  检测越界方式
     * */
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        boolean flag = x > 0;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < res) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return flag ? res : -res;
    }
}
