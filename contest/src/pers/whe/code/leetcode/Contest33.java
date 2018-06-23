package pers.whe.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest33 {

    /*
     *594. Longest Harmonious Subsequence
     *这是一道模拟题，模拟条件是找一个数的集合，集合中最大和最小相差1，
     *这样的集合可能有多个，我们找元素最多的集合。
     * 我们遍历整个数组，并用map记录元素在数组中出现的个数，并再次遍历
     * 找到符合条件的每个集合，为了避免重复计算，用set记录已经遍历过的元素
     * */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                continue;
            }
            set.add(n);
            if (map.containsKey(n - 1)) {
                res = Math.max(map.get(n) + map.get(n - 1), res);
            }
            if (map.containsKey(n + 1)) {
                res = Math.max(map.get(n) + map.get(n + 1), res);
            }
        }
        return res;
    }

    /*
     * 593. Valid Square
     * 这是一道模拟题，让我们自己找模拟条件，就是找四个点能组成正方形的模拟条件
     * 四个能组成正方形的点，那么这四点之间的连线一定只有两个，并且不能为0
     * */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(distence(p1, p2));
        set.add(distence(p1, p3));
        set.add(distence(p1, p4));
        set.add(distence(p2, p3));
        set.add(distence(p2, p4));
        set.add(distence(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }

    private int distence(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    public static void main(String[] args) {
        new Contest33().fractionAddition("1/3-1/2");
    }

    /*
     * 592. Fraction Addition and Subtraction
     *这还是一道模拟题吧，计算表达式一般要用到栈，但这道题没有优先级不用栈
     * 就可以，这道题按照一般加减法就行，不过是分数的加减法，但和整数但加减法
     * 没多大的区别，也就是遍历每一个数字，把它们加起来就行。不过分数的加减法要
     * 特殊处理
     * */
    public String fractionAddition(String expression) {
        String[] arr = expression.split("(?=[-,+])");
        int fenzi = 0, fenmu = 1;
        for (String str : arr) {
            String[] cur = str.split("/");
            int curFenzi = Integer.valueOf(cur[0]);
            int curFenmu = Integer.valueOf(cur[1]);
            fenzi = fenzi * curFenmu + curFenzi * fenmu;
            fenmu = fenmu * curFenmu;
            int curGcd = gcd(fenzi, fenmu);
            fenzi /= curGcd;
            fenmu /= curGcd;
        }
        String sign = fenmu < 0 || fenzi < 0 ? "-" : "";
        return sign + Math.abs(fenzi) + "/" + Math.abs(fenmu);
    }

    public int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }


}
