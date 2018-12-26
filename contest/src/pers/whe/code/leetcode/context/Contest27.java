package pers.whe.code.leetcode.context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest27 {

    /*
     * 557. Reverse Words in a String III
     * 这道题是一个字符串操作，我们分开字符串后，对
     * 每个字符串反转，并最后合并字符串
     * */
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str + " ");
        }
        return sb.toString().trim();
    }

    /*
     * 554. Brick Wall
     * 要尽可能少的穿过墙，那我们找到要找到位置有最多的缝，
     * 缝多，则穿过的墙少。
     * */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (List<Integer> list : wall) {
            sum = 0;
            for (int i : list) {
                sum += i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        if (map.size() == 1) return wall.size();
        int res = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            if (i == sum) continue;
            res = Math.min(res, wall.size() - map.get(i));
        }
        return res;
    }

    /*
     * 556. Next Greater Element III
     * 分为3种情况
     * 1  1234  反转最后两个
     * 2  4321  反叙，返回1
     * 3  54986  一般，从右向左找第一个反叙，4，
     * 在向右找大于4的最小值，并交换，最后排序4后面的
     * */
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int firstBig = arr.length - 2;
        while (firstBig >= 0) {
            if (arr[firstBig] < arr[firstBig + 1]) {
                break;
            }
            firstBig--;
        }
        if (firstBig == -1) return -1;
        int x = arr[firstBig], small = firstBig + 1;
        for (int j = firstBig + 1; j < arr.length; j++) {
            if (arr[j] > x && arr[small] > arr[j]) {
                small = j;
            }
        }
        char c = arr[firstBig];
        arr[firstBig] = arr[small];
        arr[small] = c;
        Arrays.sort(arr, firstBig + 1, arr.length);
        long val = Long.parseLong(new String(arr));
        return val <= Integer.MAX_VALUE ? (int) val : -1;
    }
}
