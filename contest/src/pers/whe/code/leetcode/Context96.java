package pers.whe.code.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class Context96 {

    /*
    * 887. Projection Area of 3D Shapes
    * 这道题给我们一个三维图形，让我们求三面投影的面积
    * 1 x, y  对应有值就行
    * 2 x, z  x 相同 上最大值
    * 3 y, z  y相同  最大值
    * */
    public int projectionArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res++;
                }
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            res += max;
        }
        return res;
    }


    /*
    * 885. Boats to Save People
    * 这道题给我们一些人和船，船有些限制，求多少船可以把人载完。用贪心法
    * 1 由于只能载2 个人，我们让重量最大和最小的在一起。
    *
    * */
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        int l = 0, r = people.length - 1;
        Arrays.sort(people);
        while (l <= r) {
            if (l < r && people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            res++;
        }
        return res;
    }

    /*
    * 884. Decoded String at Index
    * 这道题给我们了一些规则，让我们找第k个字符。
    * 1 找到总字符长度len，从后向前遍历。
    * 2 如果是数字q，说明字符串长乘了q，len / q。如果 k > len 则 k % len
    * 3 如过是字符，则把len--;
    * */
    public String decodeAtIndex(String s, int k) {
        long len = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                len = len * (s.charAt(i) - '0');
            } else {
                len++;
            }
        }
        long longk = k;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(s.charAt(i))) {
                if (longk == len) {
                    return s.charAt(i) + "";
                }
                len--;
            } else {
                len /= (s.charAt(i) - '0');
                if (longk > len) {
                    longk %= len;
                    if (longk == 0) {
                        longk = len;
                    }
                }
            }
        }
        return "";
    }
}
