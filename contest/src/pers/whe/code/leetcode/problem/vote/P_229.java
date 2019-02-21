package pers.whe.code.leetcode.problem.vote;

import java.util.ArrayList;
import java.util.List;

public class P_229 {

    /*
     * 229. Majority Element II
     * 同时消除三个不同的数，不影响剩下数的majority
     * */
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        int n1 = nums[0], c1 = 0, n2 = nums[0], c2 = 0;
        for (int i : nums) {
            if (n1 == i) {
                c1++;
            } else if (n2 == i) {
                c2++;
            } else if (c1 == 0) {
                n1 = i;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = i;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for (int i : nums) {
            if (i == n1) c1++;
            else if (i == n2) c2++;
        }
        List<Integer> res = new ArrayList<>();
        if (c1 >= nums.length / 3) res.add(n1);
        if (c2 >= nums.length / 3) res.add(n2);
        return res;
    }
}
