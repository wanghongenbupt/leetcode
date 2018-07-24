package pers.whe.code.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Contest18B {

    /*
    * 496. Next Greater Element I
    * 这道题求给我们两个数组，第一个是第二个的一个子集，让我们求
    * 第一个大于自己的数
    * 我们用map记录数在nums2中的位置，在用暴力来解
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

    /*
    * 506. Relative Ranks
    * 这道题给我们运动员的分数，让我们对其进行排名。
    * 1 用map记录每个运动员的分数和位置，
    * 2 对分数排序
    * 3 遍历排序后的分数，找到运动员位置，为其排名
    * */
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        reverse(nums);
        String[] res = new String[nums.length];
        if (nums.length >= 1) {
            res[map.get(nums[0])] = "Gold Medal";
        }
        if (nums.length >= 2) {
            res[map.get(nums[1])] = "Silver Medal";
        }
        if (nums.length >= 3) {
            res[map.get(nums[2])] = "Bronze Medal";
        }
        for (int i = 3; i < nums.length; i++) {
            res[map.get(nums[i])] = "" + (i + 1);
        }
        return res;
    }
    void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    /*
    * 503. Next Greater Element II
    * 这道题给我们一个数组，让我们找到第一个大于本数的数，
    * 1 遍历数组，用暴力解
    * */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = i + 1; j < nums.length * 2; j++) {
                if (nums[j % nums.length] > nums[i]) {
                    res[i] = nums[j % nums.length];
                    break;
                }
            }
        }
        return res;
    }

    /*
    * 498. Diagonal Traverse
    * 这道题给了我们一种遍历数组的方式，让我们返回遍历的结果。
    * 1 用0，和1 分别表示两个方向以便切换。
    * 2 [-1, 1] 向上  [1, -1] 向下
    *  有4种过界情况，要掉头
    *  1 x >= m x = m - 1; y = y + 2; cur = 1 - cur;
    *  2 y >= n x = x + 2; y = n - 1; cur = 1 - cur;
    *  3 x < 0  x = 0; cur = 1 - cur;
    *  4 y < 0  y = 0; cur = 1 - cur;
    *  其中 情况 1和2， 1和4 可能同时出现，
    *  但情况1就解决了情况，不可能走到下面，如果把3和4放前面可能错。
    *  如 [[1,2],[3,4]] 这种情况把4放前面会错
    * */
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int x = 0, y = 0;
        int[][] d = {{-1, 1}, {1, -1}};
        int cur = 0;
        int  n = matrix[0].length;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[x][y];
            x = x + d[cur][0];
            y = y + d[cur][1];
            if (x >= m) {
                x = m - 1; y = y + 2; cur = 1 - cur;
            }
            if (y >= n) {
                x = x + 2; y = n - 1; cur = 1 - cur;
            }
            if (x < 0) {
                x = 0; cur = 1 - cur;
            }
            if (y < 0) {
                y = 0; cur = 1 - cur;
            }
        }
        return res;
    }
}
