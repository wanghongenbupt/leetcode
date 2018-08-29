package pers.whe.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Context1 {

    /*
    * 386. Lexicographical Numbers
    * 这道题是按字典顺序打印数字，也就是一个多叉树的前序遍历
 * */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int root, int n, List<Integer> list) {
        if (root > n) return;
        list.add(root);
        for (int i = 0; i <= 9; i++) {
            if (root * 10 + i <= n) {
                dfs(root * 10 + i, n, list);
            }
        }
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

