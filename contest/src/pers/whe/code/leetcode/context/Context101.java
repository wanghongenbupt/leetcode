package pers.whe.code.leetcode.context;

import java.util.*;
import java.util.jar.JarEntry;

public class Context101 {



    /*
    * 902. Numbers At Most N Given Digit Set
    * 先说一下leetcode上面关于这个题的一个列子，列子中的N太大，我换了一个数
    * D = ["1","4","9"], N = 42222   5位
    * 1  位有  3个，     2  位有  9个，    3  位有  27个，   4  位有  108个
    * 我们可以看到每增加一位都乘了D数组的个数，求3位的时候是在2位的每个数前加了D数组的元素，
    * 为什么只在前面加，不再后面加呢？因为这样会重复。这道题的关键是找 位数和N相同时有多少个。
    * 看上面的例子，N的最高位是4，如果一个数的最高位比4小的时候，那其余位是多少都比N小，
    * 如果最高位 和 N相同，我们看次高位。
    * */
    public int atMostNGivenDigitSet(String[] D, int N) {
        int n = D.length;
        int count = 0;
        String Nstr = N + "";

        Map<Integer, Integer> expmap = new HashMap<>();
        expmap.put(0, 1);
        for (int i = 1, exp = 1; i < Nstr.length(); i++) {
            exp *= n;
            count += exp;
            expmap.put(i, exp);
        }

        TreeMap<Integer, Integer> Dindex = new TreeMap<>();
        for (int j = 0; j < n; j++) {
            Dindex.put(Integer.parseInt(D[j]), j + 1);
        }

        for (int j = 0; j < Nstr.length(); j++) {
            Integer l = Dindex.lowerKey(Nstr.charAt(j) - '0');
            if (l != null) {
                //  如果一个数的最高位比4小的时候，那其余位是多少都比N小
                count += expmap.get(Nstr.length() - j - 1) * Dindex.get(l);
            }
            if (!Dindex.containsKey(Nstr.charAt(j) - '0')) {
                return count;
            }
        }
        return count + 1;
    }



    public int numPermsDISequence(String S) {
        int n = S.length() + 1;
        int[][] dp = new int[202][202];
        dp[1][1] = 1;
        int mod = (int)1e9 + 7;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (S.charAt(i - 2) == 'D') {
                    for (int k = j; k <= i; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                } else {
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + dp[n][i]) % mod;
        }
        return res;
    }
}

/*
*
901. Online Stock Span
* */
class StockSpanner {
    List<Integer> nums = new ArrayList<>();
    List<Integer> pre =  new ArrayList<>();
    public StockSpanner() {

    }
    public int next(int price) {
        int count = 1;
        int prenum = nums.size() - 1;
        while (prenum >= 0 && nums.get(prenum) <= price) {
            count += prenum - pre.get(prenum) + 1;
            prenum = pre.get(prenum) - 1;
        }
        nums.add(price);
        pre.add(prenum + 1);
        return count;
    }
}

/*
* 900. RLE Iterator
* */
class RLEIterator {
    int start = 0;
    int index = 0;
    int[] a;
    public RLEIterator(int[] A) {
        a = A;
    }
    public int next(int n) {
        int count = 0;
        for (; start < a.length; start += 2) {
            if (count + a[start] - index >= n) {
                break;
            }
            count = count + a[start] - index;
            index = 0;
        }
        if (start >= a.length) return -1;
        index = index + n - count;
        return a[start + 1];
    }
}