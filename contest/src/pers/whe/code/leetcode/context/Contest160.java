package pers.whe.code.leetcode.context;

import java.util.*;

public class Contest160 {

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (customfunction.f(i, j) == z) {
                   res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i)
            res.add(start ^ i ^ i >> 1);
        return res;
    }

    int max = 0;
    public int maxLength(List<String> arr) {
        List<List<String>> res = new ArrayList<>();
        dfs(arr, 0, new ArrayList<>());
        return max;
    }
    void dfs(List<String> arr, int s, List<String> list) {
        boolean is = false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (char c : list.get(i).toCharArray()) {
                if (set.contains(c)) {
                    is = true;
                    break;
                } else {
                    set.add(c);
                }
            }
            if (is) break;
        }
        if (is) return;
        max = Math.max(max, set.size());
        for (int i = s; i < arr.size(); i++) {
            list.add(arr.get(i));
            dfs(arr, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int res = new Contest160().maxLength(Arrays.asList("ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po"));
        System.out.println();
    }
}
class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y){
        return 0;
    }
}