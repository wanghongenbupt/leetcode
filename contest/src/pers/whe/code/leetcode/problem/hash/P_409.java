package pers.whe.code.leetcode.problem.hash;

import java.util.HashSet;
import java.util.Set;

public class P_409 {

    /*
     * 409. Longest Palindrome
     * */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}
