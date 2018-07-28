package pers.whe.code.leetcode;

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
}
