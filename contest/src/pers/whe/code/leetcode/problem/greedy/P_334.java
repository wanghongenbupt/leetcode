package pers.whe.code.leetcode.problem.greedy;

public class P_334 {

    /*
    * 334. Increasing Triplet Subsequence
    *
     * */
    public boolean increasingTriplet(int[] nums) {
        int cur = Integer.MAX_VALUE, cur1 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= cur) {
                cur = num;
            } else if (num <= cur1) {
                cur1 = num;
            } else {
                return true;
            }
        }
        System.out.println("fds");
        return false;
    }
}