package pers.whe.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest34 {


    /*
     * 598. Range Addition II
     * 这是一道模拟题，数学题也算是模拟题吧，就是找给一些矩形，
     * 求所有矩形共同覆盖的区域，这道题比较简单的是矩形是坐标第一
     * 象限中的点和原点所形成的矩形
     * */
    public int maxCount(int m, int n, int[][] ops) {
        int x = m, y = n;
        for (int[] cur : ops) {
            x = Math.min(x, cur[0]);
            y = Math.min(y, cur[1]);
        }
        return x * y;
    }


    //  599. Minimum Index Sum of Two Lists
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (String str : map1.keySet()) {
            if (map2.containsKey(str) && min >= (map1.get(str) + map2.get(str))) {
                int cur = map1.get(str) + map2.get(str);
                if (cur < min) {
                    res = new ArrayList<>();
                    res.add(str);
                    min = cur;
                } else {
                    res.add(str);
                }
            }
        }

        return res.toArray(new String[0]);
    }


    /*
     * 565. Array Nesting
     * 这是一道模拟题，让我们找到符合一定条件的最长连，主要步骤也就是模拟生成连的条件
     * */
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            int count = 0, j = i;
            while (count == 0 || i != j) {
                count++;
                visited[j] = true;
                j = nums[j];
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /*
     *600. Non-negative Integers without Consecutive Ones
     * 这道题还是一道模拟题吧，不过模拟的条件需要我们自己找，这道题实际是一个斐波那契序列
     * 如要找小于 11111 比特不连续个数， 可以找 00000 -- 01111  和 10000 --- 11000
     * 也就是5个比特位的等于4个比特位的和3个比特位的和，我们可以用动态规划来推斐波那契数列，
     * 而斐波那契数列初始值dp[1] = 2, dp[3] = 3; dp[0] = 1, 最后如果输入的数符合条件还要加1
     * */
    public int findIntegers(int num) {
        int[] dp = new int[32];
        dp[1] = 2;
        dp[0] = 1;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int k = 30, pre_bit = 0, res = 0;
        while (k >= 0) {
            if (((1 << k) & num) != 0) {
                res += dp[k];
                if (pre_bit == 1) return res;
                pre_bit = 1;
            } else {
                pre_bit = 0;
            }
            k--;
        }
        return res + 1;
    }
}
