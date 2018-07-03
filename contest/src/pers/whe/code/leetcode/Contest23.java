package pers.whe.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contest23 {

    /*
     * 541. Reverse String II
     * 这道题就是一道模拟题，每隔2k个字符分割并操作一次。不过有几种特殊情况
     * 1 个数 <= k，直接反转返回
     * 2 个数 <= 2k 反转前k，加入后面字符
     * 3 一般情况，和2差不多
     * */
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > 0) {
            int len = s.length();
            if (len <= k) {
                sb.append(new StringBuffer(s).reverse().toString());
                break;
            } else if (len <= 2 * k) {
                StringBuilder pre = new StringBuilder(s.substring(0, k));
                String post = s.substring(k, len);
                sb.append(pre.reverse().toString());
                sb.append(post);
                break;
            } else {
                StringBuilder pre = new StringBuilder(s.substring(0, k));
                String post = s.substring(k, 2 * k);
                sb.append(pre.reverse().toString());
                sb.append(post);
                s = s.substring(2 * k);
            }
        }
        return sb.toString();
    }

    /*
     * 539. Minimum Time Difference
     * 这是一个模拟题，让我们判断一系列时钟中相隔最少多少分。
     * 1 把时钟划分为分，对它们排序并遍历找最小
     * 2 最开始分 + 1440 - 最终分 和最小比较
     * */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> res = new ArrayList<>();
        for (String str : timePoints) {
            String[] arr = str.split(":");
            res.add(Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]));
        }
        Collections.sort(res);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            min = Math.min(min, res.get(i + 1) - res.get(i));
        }
        min = Math.min(min, res.get(0) + 1440 - res.get(res.size() - 1));
        return min;
    }
}
