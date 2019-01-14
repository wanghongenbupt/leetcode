package pers.whe.code.leetcode.problem.twopoint;

public class P_202 {

    /*
    * 202. Happy Number
    * 快慢指针
     * */
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = compute(compute(fast));
            slow = compute(slow);
            if (fast == 1) return true;
        } while (fast != slow);
        return false;
    }

    private int compute(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
