package pers.whe.code.leetcode.context;
import pers.whe.code.model.TreeNode;

import java.util.*;

public class Contest99 {

    /*
     * 892. Surface Area of 3D Shapes
     * 对每个方格，我们只计算高出四周的
     * */
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int res = n * n * 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res -= 2;
                    continue;
                }
                if (i == 0) {
                    res += grid[i][j];
                } else {
                    res += Math.max(0, grid[i][j] - grid[i - 1][j]);
                }
                if (i == n - 1) {
                    res += grid[i][j];
                } else {
                    res += Math.max(0, grid[i][j] - grid[i + 1][j]);
                }
                if (j == 0) {
                    res += grid[i][j];
                } else {
                    res += Math.max(0, grid[i][j] - grid[i][j - 1]);
                }
                if (j == n - 1) {
                    res += grid[i][j];
                } else {
                    res += Math.max(0, grid[i][j] - grid[i][j + 1]);
                }
            }
        }
        return res;
    }

    /*
     * 893. Groups of Special-Equivalent Strings
     * 是Special-Equivalent，他的奇数和偶数上的字母是相同的。
     * */
    public int numSpecialEquivGroups(String[] a) {
        Set<String> set = new HashSet<>();
        for (String str : a) {
            List<Character> o = new ArrayList<>();
            List<Character> j = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    o.add(str.charAt(i));
                } else {
                    j.add(str.charAt(i));
                }
            }
            Collections.sort(o);
            Collections.sort(j);
            StringBuilder sb = new StringBuilder();
            for (char c : o) {
                sb.append(c);
            }
            for (char c : j) {
                sb.append(c);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    /*
    * 894. All Possible Full Binary Trees
    * 这题用动态规划来做，
    * 1 dp[i] 表示有i个节点的树
    * */
    public List<TreeNode> allPossibleFBT(int N) {
        List<List<TreeNode>> lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(null);
        lists.get(1).add(new TreeNode(0));
        for (int i = 2; i <= N; i++) {
            for (int l = 1; i - l - 1 >= 1; l++) {
                int r = i - l - 1;
                for (TreeNode a: lists.get(l)) {
                    for (TreeNode b: lists.get(r)) {
                        TreeNode x = new TreeNode(0);
                        x.left = a;
                        x.right = b;
                        lists.get(i).add(x);
                    }
                }
            }
        }
        return lists.get(N);
    }
}
/*
* 895. Maximum Frequency Stack
*  1 用freq记录数的频率，
*  2 用m记录频率上的数
*  3 maxF记录最大频率
* */
class FreqStack {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Stack<Integer>> m = new HashMap<>();
    int maxF = 0;

    public FreqStack() {
    }

    public void push(int x) {
        int c = freq.getOrDefault(x, 0) + 1;
        freq.put(x, c);
        maxF = Math.max(c, maxF);
        if (!m.containsKey(c)) {
            m.put(c, new Stack<>());
        }
        m.get(c).push(x);
     }

    public int pop() {
        int x = m.get(maxF).pop();
        freq.put(x, freq.get(x) - 1);
        if (m.get(maxF).size() == 0) {
            maxF--;
        }
        return x;
    }
}