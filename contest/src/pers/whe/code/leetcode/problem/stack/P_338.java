package pers.whe.code.leetcode.problem.stack;

import java.util.Stack;

public class P_338 {
    /*
    * 388. Longest Absolute File Path
    * stack记录父节点数量。
     * */
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (String str : input.split("\n")) {
            int lev = str.lastIndexOf("\t") + 1;
            while (lev + 1 < stack.size()) stack.pop();
            int len = stack.peek() + str.length() - lev + 1;
            stack.push(len);
            max = Math.max(max, len - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "\t\t12";
        System.out.println(str.lastIndexOf("\t"));
        System.out.println(str.length());
    }
}
