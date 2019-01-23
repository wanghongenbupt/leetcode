package pers.whe.code.leetcode.problem.random;

public class P_470 {

    /*
     * 470. Implement Rand10() Using Rand7()
     * 用两次 rand7() 得到 1-40的数，res % 10 + 1
     * */
    public int rand10() {
        int r, c, res;
        do {
            r = rand7();
            c = rand7();
            res = c + (r - 1) * 7;
        } while (res > 40);
        return res % 10 + 1;
    }

    int rand7() {
        return 0;
    }
}
