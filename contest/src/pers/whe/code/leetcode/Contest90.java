package pers.whe.code.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Contest90 {

    /*
     * 859. Buddy Strings
     * 这道题让我们判断只交换A中的两个字符是否可以等于B，
     * 1 判断两个字符中对应元素个数是否相等
     * 2 判断对应位置不行等的个数，如果不等于两个，则不可能通过交换两个就可以转换到B
     * 3 如果对应位置全相等，如果一个元素的数量 > 2, 则可以通过交换这个元素得到B
     *
     * time o(n) space o(1)
     * */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] arr = new int[256];
        boolean two = false;
        for (int i = 0; i < A.length(); i++) {
            if (++arr[A.charAt(i)] >= 2) {
                two = true;
            }
        }
        for (int i = 0; i < B.length(); i++) {
            arr[B.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        int diff = 0;
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
            }
        }
        if (diff == 2) return true;
        if (two && diff == 0) return true;
        return false;
    }

    /*
     * 856. Score of Parentheses
     * 这个题是给出一种字符串的定义，由于带有括号，通常都需要用到栈，或者递归，
     * 第一种方法用栈来解
     * */

    /*
     * method one  stack
     * 由于括号有优先顺序，可以用栈记录左括号，
     * 1 当遇到右括号的时候，如果栈顶是左括号，把栈顶元素弹出，并入栈1
     * 2 当栈顶是数字的时候，表明了嵌套，计算嵌套中的值，并把和 * 2
     * 3 把栈内元素相加
     * time o(n)  space o(n)
     * */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                if (stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int cur = 0;
                    while (stack.peek() != -1) {
                        cur += stack.peek();
                        stack.pop();
                    }
                    stack.pop();
                    stack.push(cur * 2);
                }
            }
        }
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        return sum;
    }

    /*
     * method 2 递归，有两种情况
     * 如果开始没有嵌套的话，直接返回1加后面的
     * 如果有嵌套， 可以把括号去掉，加后面的
     * time o(n)
     * */
    public int scoreOfParentheses2(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            return 1 + scoreOfParentheses2(s.substring(2));
        }
        int d = 0;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                end = i + 1;
                break;
            }
        }
        return 2 * scoreOfParentheses2(s.substring(1, end - 1)) + scoreOfParentheses2(s.substring(end));
    }

    /*
     * 858. Mirror Reflection
     * 首先要明白激光不会上下震动，只会左右震动。
     * 所以每一次左右方向都会改变，而上下的方向只有到头才会改变。
     * remain表示还要多长才能到达顶点，如果每次都会减少q，如果变负的话，
     * 要去另一边，而remain = p - remain
     *
     * */
    public int mirrorReflection(int p, int q) {
        boolean up = true;
        boolean east = true;
        int remain = p;
        while (true) {
            remain -= q;
            if (remain == 0) {
                if (up) {
                    if (east) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    if (east) {
                        return 0;
                    }
                }
            }
            if (remain < 0) {
                remain += p;
                up = !up;
            }
            east = !east;
        }
    }

    /*
     * 857. Minimum Cost to Hire K Workers
     * 这道题主要求个数为K的员工，期望薪资和质量乘最小值。
     * 可以先按期望薪资排名，并计算前面K个员工的薪资。
     * */
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] works = new double[q.length][2];
        for (int i = 0; i < q.length; i++) {
            works[i] = new double[]{(double) (w[i]) / q[i], (double) q[i]};
        }
        Arrays.sort(works, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, sumq = 0.0;
        PriorityQueue<Double> queue = new PriorityQueue<>();
        for (double[] work : works) {
            sumq += q[1];
            queue.add(-work[1]);
            if (queue.size() > K) {
                sumq += queue.poll();
            }
            if (queue.size() == K) {
                res = Math.min(res, sumq * work[0]);
            }
        }
        return res;
    }
}
