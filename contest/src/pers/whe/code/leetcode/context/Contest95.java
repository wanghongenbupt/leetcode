package pers.whe.code.leetcode.context;

import pers.whe.code.model.ListNode;
import pers.whe.code.util.MathUtil;

public class Contest95 {

    /*
     * 876. Middle of the Linked List
     * 这道题让我们找链表的中间节点
     * 1 先找出链表的长度 n
     * 2 n / 2 + 1 就是链表中间位置。
     * */
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode pre = head;
        while (pre != null) {
            n++;
            pre = pre.next;
        }
        int res = n / 2 + 1;
        n = 1;
        pre = head;
        while (n != res) {
            pre = pre.next;
            n++;
        }
        return pre;
    }

    /*
     *877. Stone Game
     * 这道题是博弈问题，博弈问题一般用记忆化搜索来做，但这道题有个条件，就是数组的个数是偶数，并且和是奇数。
     * 我们把数组分为奇数和偶数索引，那么奇数和偶数索引对应数的和肯定是不一样的，并且有大有小。
     * 而数组的个数是偶数个，第一个人肯定可以选择只取偶数索引的或奇数索引的，如果奇数索引的大，那么取奇数的。
     *
     * 为什么可以选取奇数或偶数的呢，
     * 如索引 0，1，2，3，4，5  如过想取偶数的，那么取0，剩两边的1，5都为奇数。
     *
     * */
    public boolean stoneGame(int[] piles) {
        return true;
    }

    /*
     * 878. Nth Magical Number
     * 这道题找能被A和B整除的第N个整数。这是第一种方法，暴力方法。
     * 如果 A = 2, B = 3; 看下面两行内容.
     * 2 = 1 * 2；  4 = 2 * 2；  6 = 3 * 2；
     * 3 = 1 * 3；  6 = 2 * 3；  9 = 3 * 3；
     * 我们可以用两个值numa, numb 记录相乘的个数，并从1遍历到N，找到对应值。
     * */
    public int nthMagicalNumber1(int N, int A, int B) {
        long a = A, b = B;
        int numa = 0, numb = 0;
        long min = 0L;
        for (int i = 1; i <= N; i++) {
            int ca = ++numa, cb = ++numb;
            min = Math.min(ca * a, cb * b);
            if (min == ca * a) numa++;
            if (min == cb * b) numb++;
        }
        return (int) (min % 1000000007);
    }

    /*
     * 878. Nth Magical Number
     * 这是第二种方法，用二分法找到答案。
     * 对于1个数m，m / a + m / b - m / d 计算出来的就是第几个，其中d为a,b的最小公倍数。
     * */
    public int nthMagicalNumber2(int N, int A, int B) {
        long a = A, b = B, l = 2, r = (long) Math.pow(10, 14);
        long d = (A * B) / MathUtil.findGCD(A, B);
        while (l < r) {
            long m = (l + r) / 2;
            if ((m / a + m / b - m / d) < N) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return (int) (l % (long) (Math.pow(10, 9) + 7));
    }

    /*
     * 879. Profitable Schemes
     * 这道题用动态规划，
     * 1 状态： dp[i][j]   j个人获得i个利益的方法个数
     * 2 动态方乘  newdp[minp][j + g] = (newdp[minp][j + g] + olddp[i][j]) % mod;
     * 3 初始状态  dp[0][0] = 1;
     *   由于是从0开始遍历的，我们要用以前的值，如果不用另一个的话会用到当前轮的值。
     * */
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] olddp = new int[P + 1][G + 1];
        olddp[0][0] = 1;
        int mod = (int) 1e9 + 7;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            int[][] newdp = new int[P + 1][G + 1];
            for (int i = 0; i <= P; i++) {
                for (int j = 0; j <= G; j++) {
                    newdp[i][j] = olddp[i][j];
                }
            }
            for (int i = 0; i <= P; i++) {
                for (int j = 0; j + g <= G; j++) {
                    int minp = Math.min(P, i + p);
                    newdp[minp][j + g] = (newdp[minp][j + g] + olddp[i][j]) % mod;
                }
            }
            olddp = newdp;
        }
        int res = 0;
        for (int i : olddp[P]) {
            res = (res + i) % mod;
        }
        return res;
    }
}
