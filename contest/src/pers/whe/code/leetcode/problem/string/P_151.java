package pers.whe.code.leetcode.problem.string;

import java.util.Arrays;
import java.util.Collections;

public class P_151 {

    /*
    *151. Reverse Words in a String
    * Arrays.asList(words) 对链表的操作会反映到数组上。
    * String.join
    * */
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
