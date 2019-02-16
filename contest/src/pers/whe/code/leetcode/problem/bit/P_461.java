package pers.whe.code.leetcode.problem.bit;

public class P_461 {

    /*
     * 461. Hamming Distance
     * */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
