package pers.whe.code.leetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import pers.whe.code.model.TreeNode;
import pers.whe.code.work.Main;

import java.util.*;

public class Context105 {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        sb.reverse();
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 0; j < S.length(); j++) {
            if (!Character.isLetter(S.charAt(j))) {
                res.append(S.charAt(j));
            } else {
                res.append(sb.charAt(i++));
            }
        }
        return res.toString();
    }


    public int maxSubarraySumCircular(int[] a) {
        int sum = a[0], min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            int curmax = Math.max(a[i], max + a[i]);
            max = Math.max(max, curmax);
            int curmin = Math.max(a[i], min + a[i]);
            min = Math.min(a[i], min + a[i]);
            sum += a[i];
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}

class CBTInserter {

    Map<Integer, TreeNode> map = new HashMap<>();
    int[] arr = new int[20000];
    int index = 1;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            map.put(index, cur);
            index++;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public int insert(int v) {
        int p = index / 2;
        TreeNode par = map.get(p);
        if (par.left != null) {
            par.left = new TreeNode(v);
            map.put(index, par.left);
        } else {
            par.right = new TreeNode(v);
            map.put(index, par.right);
        }
        index++;
        return arr[p];
    }

    public TreeNode get_root() {
        return root;
    }
}