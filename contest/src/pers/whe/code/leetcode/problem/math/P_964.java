package pers.whe.code.leetcode.problem.math;

public class P_964 {

    /*
    * 964. Least Operators to Express Number
    * 只用一个数x表示t, 可以有两种情况，举个例子用 3 表示 1。
    * 1、 3 / 3
    * 2、 3 - 3 / 3 - 3 / 3；
    * 所以用这种方式做这道题， pos 表示第一种情况，neg表示第二种情况（没包括最前面的3）
    * 求的余数cur 总比x小，就是 例子中 3 比 1 小。
    * */
    public int leastOpsExpressTarget(int x, int y) {
        int pos = 0, neg = 0, k = 0, pos2, neg2, cur;
        while (y > 0) {
            cur = y % x;
            y /= x;
            if (k > 0) {
                pos2 = Math.min(cur * k + pos, (cur + 1) * k + neg);
                neg2 = Math.min((x - cur) * k + pos, (x - cur - 1) * k + neg);
                pos = pos2;
                neg = neg2;
            } else {
                pos = cur * 2;
                neg = (x - cur) * 2;
            }
            k++;
        }
        return Math.min(pos, neg + k) - 1;
    }
}
