package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Contest18A {
    /*
     * 500. Keyboard Row
     * 这道题让我们找字符串是否能由键盘中的行构成。
     * 1 遍历字符串字母，如果在不同行跳出，如果在同一行加入。
     * */
    public String[] findWords(String[] words) {
        List<Character> row1 = Arrays.asList('q','w','e','r','t','y','u','i','o','p');
        List<Character> row2 = Arrays.asList('a','s','d','f','g','h','j','k','l');
        List<Character> row3 = Arrays.asList('z','x','c','v','b','n','m');
        List<String> list = new ArrayList<>();
        for (String str : words) {
            int row = -1;
            boolean flag = true;
            for (char c : str.toCharArray()) {
                char ch = Character.toLowerCase(c);
                if (row == -1) {
                    if(row1.contains(ch)) row = 1;
                    if(row2.contains(ch)) row = 2;
                    if(row3.contains(ch)) row = 3;
                }
                if(row1.contains(ch) && row == 1) {
                    continue;
                } else if(row2.contains(ch) && row == 2) {
                    continue;
                } else if(row3.contains(ch) && row == 3) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);   
    }

    /*
     * 508. Most Frequent Subtree Sum
     * 这道题让我们求子树的和中出现频率最大的数。
     * 1 用map记录和出现的频率。
     * 2 用dfs求子树的和。
     * 3 遍历map求最大的频率max
     * 4 遍历map求出现max频率的数
     * */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = 0;
        for (int i : map.values()) {
            max = Math.max(i, max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                res.add(i);
            }
        }
        int[] item = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            item[i] = res.get(i);
        }
        return item;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int val = left + right + root.val;
        map.putIfAbsent(val, 0);
        map.put(val, map.get(val) + 1);
        return val;
    }

    /*
    * 502. IPO
    * 这道题给我们几个项目，项目包括资本和利润，如果我们手中的钱大于等于资本，就可以开始这个项目，
    *  现在有 w资本，最多有k个项目，问最多能有少钱，用贪心法
    *  1 找到现在满足的所有项目，找到最大利润项目，
    *  2 循环k次，直到没有满足条件的项目
    *
    * */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->a[1] - b[1]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)->b[0] - a[0]);

        for (int i = 0; i < Profits.length; i++) {
            min.offer(new int[]{Profits[i], Capital[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && min.peek()[1] <= W) {
                max.offer(min.poll());
            }
            if (max.isEmpty()) {
                break;
            }
            W += max.poll()[0];
        }
        return W;
    }
}
