package pers.whe.code.leetcode.context;

import pers.whe.code.model.TreeNode;

import java.util.*;

public class Context117 {

    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) &&
                (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }


    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> cur = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 2; i <= n; i++) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (x > 0 && y + k < 10)
                    cur2.add(x * 10 + y + k);
                if (x > 0 && k > 0 && y - k >= 0) {
                    cur2.add(x * 10 + y - k);
                }
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(i -> i).toArray();
    }


    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(queries));
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    /*
    * 0 leaf;
    * 1 parent need camera
    * 2 covered;
    * */
    private int dfs(TreeNode root) {
        int left = root.left == null ? 2 : dfs(root.left),
            right = root.right == null ? 2 : dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}