package pers.whe.code.leetcode.problem.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_936 {

    /*
     * 936. Stamping The Sequence
     * 找到能匹配stamp的，并把他们变成 *，*可以成为任何字母，
     * 找到下次可匹配，最后直到target全为*
     * */
    String target = "";

    public int[] movesToStamp(String stamp, String target) {
        int n = target.length();
        this.target = target;
        boolean[] see = new boolean[n];
        List<Integer> list = new ArrayList<>();
        int total = 0;
        while (total < n) {
            boolean ok = false;
            for (int i = 0; i <= n - stamp.length(); i++) {
                if (see[i]) continue;
                int l = unstamp(stamp, i);
                if (l == 0) continue;
                see[i] = true;
                list.add(i);
                ok = true;
                total += l;
            }
            if (!ok) return new int[0];
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int unstamp(String stamp, int s) {
        int l = stamp.length();
        for (int i = 0; i < stamp.length(); i++) {
            if (target.charAt(s + i) == '*')
                l--;
            else if (target.charAt(s + i) != stamp.charAt(i))
                return 0;
        }
        if (l != 0) {
            char[] arr = target.toCharArray();
            for (int i = 0; i < stamp.length(); i++) {
                arr[s + i] = '*';
            }
            target = new String(arr);
        }
        return l;
    }

    public static void main(String[] args) {
        new P_936().movesToStamp("abc",
                "ababc");
    }
}
