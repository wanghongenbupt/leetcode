package pers.whe.code.codejam;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 2个字符串都可能有*
 * 如果这个字符串最开始都是*，那可以去掉其中一个，因为两个*取同样的字符是浪费
 *
 * bug: 考虑 * 与 aa*bb
 * fix: 把*全部换成4个？,那？就是必须匹配上
 *
 * 死循环。。。。好多重复的计算，但是为什么之前的递归没有死循环？？？？
 * (长度是原来的4倍，但是复杂度是指数增长！！)
 */
public class Main {

    static Map<String, Boolean> m = new HashMap<String, Boolean>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("b.in")));
        PrintStream ps = new PrintStream(new FileOutputStream("a.out"));
        System.setOut(ps);

        int cnt = sc.nextInt();
        for (int cc = 1; cc <= cnt; cc++) {
            String s = sc.next(), t = sc.next();
            boolean f = ok(s.replace("*", "????"), t.replace("*", "????"));
            if (f)
                System.out.println("Case #" + cc + ": TRUE");
            else
                System.out.println("Case #" + cc + ": FALSE");
        }

    }

    public static boolean ok(String s, String t) {
        if ("".equals(s) && "".equals(t)) return true;
        if ("".equals(s)) return t.replace("?", "").equals("");
        if ("".equals(t)) return s.replace("?", "").equals("");
        if (m.containsKey(s + " " + t)) return m.get(s + " " + t);

        boolean f = false;


        /*
         * 就是按照思路来递归啊
         * ？可以匹配一个字符，也可以不匹配字符
         */
        if (s.charAt(0) == '?' && t.charAt(0) == '?')
            f = ok(s.substring(1), t) || ok(s, t.substring(1));
        else if (s.charAt(0) == '?')
            f = ok(s.substring(1), t) || ok(s.substring(1), t.substring(1));
        else if (t.charAt(0) == '?')
            f = ok(s, t.substring(1)) || ok(s.substring(1), t.substring(1));
        else
            f = s.charAt(0) == t.charAt(0) && ok(s.substring(1), t.substring(1));

        m.put(s + " " + t, f);
        return f;
    }
}