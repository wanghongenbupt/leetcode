package pers.whe.code.leetcode.problem.string;

import java.util.Stack;

public class P_316 {
    /*
     * 316. Remove Duplicate Letters
     * 由于题目要尽量按字典顺序返回，所以每当加入一个字符的
     * 时候就要和结果字符串的末尾比较，如果当前字符比末尾字符小，
     * 并且末尾字符在后面还会出现，就把末尾字符去掉。
     * */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] see = new boolean[256];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c]--;
            if (see[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0) {
                see[stack.peek()] = false;
                stack.pop();
            }
            stack.push(c);
            see[c] = true;
        }
        String res = "";
        for (char c : stack) res += c;
        return res;
    }
}