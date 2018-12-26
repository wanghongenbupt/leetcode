package pers.whe.code.leetcode.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Contest89 {


    /*
     *852. Peak Index in a Mountain Array
     * 这是一道模拟题，只要用编程语言模拟出给出条件就行
     * 时： O(n) 空：O(1)
     * */
    public int peakIndexInMountainArray(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 853. Car Fleet
     * 这也算是一个模拟题吧，不过需要通过模拟条件导出一些结论，
     * 如前后两个车，要走到相同的终点，如果前面的车用时小，
     * 一定可以在到达终点时追上后一个车，这两个车就是fleet
     * 时：O(nlog(n))  空： O(n)
     * */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res = 0;
        double[][] cars = new double[n][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }

    /*
     * 854. K-Similar Strings
     * 这道题是dfs，就是用暴力解法解决问题，我们尽量让a变为b,
     * 顺序遍历a,b的每个位置，如果相等，遍历下个位置，如果不等，
     * 可以交换a中此位置之后的和b相等的位置，我们还可以记下已解决的问题，'
     * 来提高执行效率。
     * */
    public int kSimilarity(String a, String b) {
        return dfs(a.toCharArray(), b.toCharArray(), 0, new HashMap<String, Integer>());
    }

    private int dfs(char[] arr, char[] brr, int idx, HashMap<String, Integer> map) {
        if (idx >= arr.length) return 0;
        String A = new String(arr);
        String B = new String(brr);
        String str = A + "_" + B;
        if (!map.containsKey(str)) {
            int min = Integer.MAX_VALUE;
            if (arr[idx] == brr[idx]) {
                min = Math.min(min, dfs(arr, brr, idx + 1, map));
            } else {
                for (int i = idx + 1; i < arr.length; i++) {
                    if (arr[i] == brr[idx]) {
                        swap(arr, i, idx);
                        min = Math.min(min, dfs(arr, brr, idx + 1, map) + 1);
                        swap(arr, i, idx);
                    }
                }
            }
            map.put(str, min);
        }
        return map.get(str);
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    /*
     *855. Exam Room
     * 这道题也算是模拟题吧，就是求给定满足条件的解，
     * 用list记录所在位置，在seat中遍历list记录，找到合适的位置，
     * 并插入其中
     * 时： O(n)  空： O(n)
     * */
    class ExamRoom {

        int n;
        List<Integer> list = new ArrayList<>();

        public ExamRoom(int N) {
            n = N;
        }

        public int seat() {
            if (list.size() == 0) {
                list.add(0);
                return 0;
            }
            int d = Math.max(list.get(0), n - 1 - list.get(list.size() - 1));
            for (int i = 0; i < list.size() - 1; i++) {
                d = Math.max(d, (list.get(i + 1) - list.get(i)) / 2);
            }
            if (d == list.get(0)) {
                list.add(0, 0);
                return 0;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                if (d == (list.get(i + 1) - list.get(i)) / 2) {
                    list.add(i + 1, (list.get(i) + list.get(i + 1)) / 2);
                    return list.get(i + 1);
                }
            }
            list.add(n - 1);
            return n - 1;
        }

        public void leave(int p) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == p) {
                    list.remove(i);
                }
            }
        }
    }
}
